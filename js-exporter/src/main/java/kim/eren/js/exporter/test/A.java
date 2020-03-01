package kim.eren.js.exporter.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.QualifiedNameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;

import kim.eren.js.exporter.ClazzContainer;
import kim.eren.js.exporter.JsInfo;

public class A implements Predicate<Path> {

	List<Path> clazzWhichContainsSerializer = new ArrayList<Path>();
	List<JsInfo> jsInfoList = new ArrayList<JsInfo>();
	private String projectPath = null;
	private String serializerPackageName = null;
	private String serializerClazzName = null;
	private static final String JS_CLAZZ_TEMPLATE = "<-imports->\n" + "\n"
			+ "export default class <clazzname> <-parent clazz->{\n" + "    deSerializeProps(oParser){\n"
			+ "        <-proplist->\n" + "    }\n" + "}";
	private static final String JS_BLANKS_IMPORT = "<-imports->";
	private static final String JS_BLANKS_CLAZZ_NAME = "<clazzname>";
	private static final String JS_BLANKS_PARENT_CLAZZ_NAME = "<-parent clazz->";
	private static final String JS_BLANKS_PROP_LIST = "<-proplist->";
	private static Object SERIALIZER_FULL_PATH = null;
	private static final String ANONYMOUS_CLAZZ_METHOD_NAME = "readInstance";

	@Override
	public boolean test(Path p) {
		boolean fileExtensionCorrect = false, fileHasSerializer = false;
		fileExtensionCorrect = p.toString().endsWith(".java");
		try {
			fileHasSerializer = findSerializer(p.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileExtensionCorrect && fileHasSerializer;
	}

	public String getSerializerFullPath() {
		return serializerPackageName + "." + serializerClazzName;
	}

	public String getSerializerPackageName() {
		return serializerPackageName;
	}

	public void prepareSerializerList() throws IOException {
		Files.walk(Paths.get(projectPath)).filter(this).forEach((e) -> clazzWhichContainsSerializer.add(e));
	}

	private BufferedReader getBufferedReader(File f) {
		try {
			return new BufferedReader(new FileReader(f));

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		}
		return null;
	}

	private static class AnonymousClazzExpressionVisitor extends GenericVisitorAdapter<List<BodyDeclaration>, Void> {
		@Override
		public List<BodyDeclaration> visit(ObjectCreationExpr n, Void arg) {
			return n.getAnonymousClassBody();
		}
	}

	private static class BodyExpressionVisitor extends GenericVisitorAdapter<List<Expression>, Void> {
		@Override
		public List<Expression> visit(MethodCallExpr n, Void arg) {
			return n.getArgs();
		}
	}

	private static class QualifiedDeclarationVisitor extends GenericVisitorAdapter<String, Void> {
		@Override
		public String visit(QualifiedNameExpr n, Void arg) {
			return n.toString();
		}
	}

	private static class ImportDeclarationVisitor extends GenericVisitorAdapter<NameExpr, Void> {
		@Override
		public NameExpr visit(QualifiedNameExpr n, Void arg) {
			return n.getQualifier();
		}
	}

	public boolean findSerializer(File file) throws IOException {
		if (!file.isDirectory()) {
			CompilationUnit unit = getCompileUnit(file);
			List<ImportDeclaration> importList = unit.getImports();
			ImportDeclarationVisitor importDeclarationVisitor = new ImportDeclarationVisitor();
			QualifiedDeclarationVisitor qdv = new QualifiedDeclarationVisitor();
			for (ImportDeclaration importDeclaration : importList) {
				NameExpr importNameExpr = importDeclaration.getName().accept(importDeclarationVisitor, null);
				String importPath = importNameExpr.accept(qdv, null);
				if (importPath.equals(getSerializerPackageName())) {
					return true;
				}
			}
		}
		return false;
	}

	public Map<String, String> getImportedPackageList(CompilationUnit unit) {
		Map<String, String> importListAsString = new HashMap<String, String>();
		List<ImportDeclaration> importList = unit.getImports();
		ImportDeclarationVisitor importDeclarationVisitor = new ImportDeclarationVisitor();
		for (ImportDeclaration importDeclaration : importList) {
			NameExpr importNameExpr = importDeclaration.accept(importDeclarationVisitor, null);
			String path = importNameExpr.toString();
			importListAsString.put(importDeclaration.getName().getName(), path);
		}
		return importListAsString;
	}

	public CompilationUnit getCompileUnit(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		CompilationUnit unit = null;
		try {
			unit = JavaParser.parse(fis);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
		return unit;
	}

	public void prepareJsInfoList2() throws IOException {
		for (Path p : clazzWhichContainsSerializer) {
			JsInfo jsInfo = new JsInfo();
			CompilationUnit unit = getCompileUnit(p.toFile());
			Map<String, String> importedPackageMap = getImportedPackageList(unit);
			String packageName = unit.getPackage().getName().toString();
			String name = getClazzName(unit);
			// that method must be get a importList
			Map<String, ClazzContainer> propList = preparePropsList(unit);
			jsInfo.setPropList(propList);

		}

	}

	private String getClazzName(CompilationUnit unit) {
		
		return null;
	}

	private Map<String, ClazzContainer> preparePropsList(CompilationUnit unit) {
		List<TypeDeclaration> types = unit.getTypes();
		for (TypeDeclaration type : types) {
			List<BodyDeclaration> bodyDeclarations = type.getMembers();
			for (BodyDeclaration bodyDeclaration : bodyDeclarations) {
				if (bodyDeclaration instanceof FieldDeclaration) {
					FieldDeclaration field = (FieldDeclaration) bodyDeclaration;
					Type fType = field.getType();
					if (fType.toString().equals(serializerClazzName)) {
						List<VariableDeclarator> vars = field.getVariables();
						VariableDeclarator vDeclarator = vars.get(0);
						Expression expression = vDeclarator.getInit();
						AnonymousClazzExpressionVisitor namePrinter = new AnonymousClazzExpressionVisitor();
						List<BodyDeclaration> anonymousClassBodys = expression.accept(namePrinter, null);
						Map<String, String> propList = findPropList(anonymousClassBodys);
					}
				}

			}
		}
		return null;
	}

	public Map<String, String> findPropList(List<BodyDeclaration> bodyDecList) {
		Map<String, String> propList = new HashMap<>();
		for (BodyDeclaration bodyDeclaration : bodyDecList) {
			if (bodyDeclaration instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration) bodyDeclaration;
				if (ANONYMOUS_CLAZZ_METHOD_NAME.equals(method.getName())) {
					BlockStmt body = method.getBody();
					body.getChildrenNodes();
					BodyExpressionVisitor bExpressionVisitor = new BodyExpressionVisitor();
					for (Node node : body.getChildrenNodes()) {
						List<Expression> bExpresionList = node.accept(bExpressionVisitor, null);
						String key = bExpresionList.get(0).toString();
						String value = bExpresionList.get(1).toString();
						System.out.println("Method Name Printed: " + key + "value " + value);
						propList.put(key, value);
					}
				}
			}
		}
		return propList;
	}

	public void prepareJsInfoList() {
		for (Path p : clazzWhichContainsSerializer) {
			File f = p.toFile();
			JsInfo jsInfo = new JsInfo();
			BufferedReader br = getBufferedReader(f);
			String st;
			Map<String, String> importList = new HashMap<String, String>();
			try {
				while ((st = br.readLine()) != null) {
					if (jsInfo.getPackageName() == null) {
						preparePackageName(st, jsInfo);
					}
					readImportLine(st, importList);
					if (jsInfo.getName() == null) {
						prepareName(st, jsInfo);
					}
					if (jsInfo.getParentClazzName() == null) {
						prepareParentClazzName(st, jsInfo);
					}
					preparePropLines(st, jsInfo, br);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			prepareClazzPackageNames(jsInfo, importList);
			jsInfoList.add(jsInfo);
		}
	}

	public void prepareClazzPackageNames(JsInfo jsInfo, Map<String, String> importList) {
		if (jsInfo.getParentClazzName() != null) {
			String parentClazzName = jsInfo.getParentClazzName().getName();
			String packageName = importList.get(parentClazzName);
			// if parent package name null? must be in same package;
			if (packageName == null) {
				packageName = jsInfo.getPackageName();
			}
			jsInfo.getImportList().put(parentClazzName, packageName);
			jsInfo.getParentClazzName().setPackageName(packageName);
		}
		if (!jsInfo.getPropList().isEmpty()) {
			for (String s : jsInfo.getPropList().keySet()) {
				ClazzContainer cContainer = jsInfo.getPropList().get(s);
				String clazzName = cContainer.getName().substring(0, cContainer.getName().indexOf("."));
				String packageName = importList.get(clazzName);
				jsInfo.getImportList().put(clazzName, packageName);
				cContainer.setPackageName(packageName);
			}
		}

	}

	public void readImportLine(String st, Map<String, String> importList) {
		Pattern p = Pattern.compile("import");
		Matcher m = p.matcher(st);
		if (m.find()) {
			String fullPackageName = parseImportLine(st);
			String clazzName = parseClazzNameFromImport(fullPackageName);
			importList.put(clazzName, fullPackageName);
		}
	}

	public String parseClazzNameFromImport(String fullPackageName) {
		String clazzName = fullPackageName.substring(fullPackageName.lastIndexOf(".") + 1, fullPackageName.length());
		return clazzName;
	}

	public String parseImportLine(String st) {
		String importValue = st.substring(0, st.indexOf(";")).split(" ")[1];
		return importValue;
	}

	private void prepareParentClazzName(String st, JsInfo jsInfo) {
		Pattern pattern = Pattern.compile("extends");
		Matcher m = pattern.matcher(st);
		if (m.find()) {
			String clazzName = findExtendedClazzName(st);
			ClazzContainer cContainer = new ClazzContainer();
			cContainer.setName(clazzName);
			jsInfo.setParentClazzName(cContainer);
		}
	}

	public String findExtendedClazzName(String st) {
		String extendedClazzLine = st.substring(st.indexOf("extends"), st.length());
		String[] extendedClazzLineParts = extendedClazzLine.split(" ");
		String parentClazzName = extendedClazzLineParts[1];
		return parentClazzName;

	}

	private void preparePropLines(String st, JsInfo jsInfo, BufferedReader br)
			throws IOException, ClassNotFoundException {
		Pattern pattern = Pattern.compile("new " + serializerClazzName);
		Matcher m = pattern.matcher(st);
		if (m.find()) {
			while ((st = br.readLine()) != null) {
				pattern = Pattern.compile("readInstance");
				m = pattern.matcher(st);
				if (m.find()) {
					while ((st = br.readLine()) != null) {
						pattern = Pattern.compile("\\((.*?)\\)");
						m = pattern.matcher(st);
						if (m.find()) {
							pattern = Pattern.compile(".class");
							m = pattern.matcher(st);
							if (m.find()) {
								setPropToList(st, jsInfo);
							}
						}
					}
				}
			}
		}

	}

	public void setPropToList(String st, JsInfo jsInfo) throws ClassNotFoundException {
		String bracetsBody = st.substring(st.indexOf("(") + 1, st.lastIndexOf(")"));
		String[] bracetsBodyParts = bracetsBody.split(",");
		String name = bracetsBodyParts[0].trim();
		String fullClazzName = bracetsBodyParts[1].trim();
		ClazzContainer cContainer = new ClazzContainer();
		cContainer.setName(fullClazzName);
		jsInfo.addPropToList(name, cContainer);
	}

	private void prepareName(String st, JsInfo jsInfo) {
		Pattern pattern = Pattern.compile(" class ");
		Matcher m = pattern.matcher(st);
		if (jsInfo.getName() == null && m.find()) {
			String name = getNameFromLine(st);
			jsInfo.setName(name);
		}

	}

	private void preparePackageName(String st, JsInfo jsInfo) {
		Pattern pattern = Pattern.compile("package");
		Matcher m = pattern.matcher(st);
		if (m.find()) {
			String packageName = getPackageNameFromLine(st);
			jsInfo.setPackageName(packageName);
		}

	}

	public String getNameFromLine(String st) {
		return st.substring(st.indexOf("class "), st.indexOf("{")).split(" ")[1];
	}

	public String getPackageNameFromLine(String st) {
		String packageName = st.substring(0, st.indexOf(";")).split(" ")[1];
		return packageName;
	}

	public void createJsFiles() {
		for (JsInfo jsInfo : jsInfoList) {
			// first create string files
			String jsClazzAsString = prepareJsClazzAsString(jsInfo);
			//
		}
	}

	public String prepareJsClazzAsString(JsInfo jsInfo) {
		StringBuilder clazzAsString = new StringBuilder(JS_CLAZZ_TEMPLATE);
		prepareJsClazzImports(jsInfo.getImportList(), clazzAsString);
		prepareJsClazzNameAndParent(jsInfo.getName(), jsInfo.getParentClazzName(), clazzAsString);
		prepareJsClazzDeSerializeFunction(jsInfo.getPropList(), clazzAsString);
		return clazzAsString.toString();
	}

	private void prepareJsClazzDeSerializeFunction(Map<String, ClazzContainer> propList, StringBuilder clazzAsString) {
		// TODO Auto-generated method stub

	}

	private void prepareJsClazzNameAndParent(String name, ClazzContainer parentClazzName, StringBuilder clazzAsString) {
		int nameConstStartIndex = clazzAsString.indexOf(JS_BLANKS_CLAZZ_NAME);
		clazzAsString.replace(nameConstStartIndex, nameConstStartIndex + JS_BLANKS_CLAZZ_NAME.length(), name);
		if (parentClazzName != null && !"".equals(parentClazzName.getName())) {
			int parentConstStartIndex = clazzAsString.indexOf(JS_BLANKS_PARENT_CLAZZ_NAME);
			clazzAsString.replace(parentConstStartIndex, parentConstStartIndex + JS_BLANKS_PARENT_CLAZZ_NAME.length(),
					" extends " + parentClazzName.getName());
		}

	}

	public void prepareJsClazzImports(Map<String, String> importList, StringBuilder clazzAsString) {
		StringBuilder importAsString = new StringBuilder();
		importAsString.append("import PS from \"../PS.js\";\n");
		for (String key : importList.keySet()) {
			String value = importList.get(key);
			if (value != null && !"".equals(value)) {
				String jsImportLine = prepareJsImportLine(key, value);
				importAsString.append(jsImportLine);

			}
		}
		int nameConstStartIndex = clazzAsString.indexOf(JS_BLANKS_IMPORT);
		clazzAsString.replace(nameConstStartIndex, nameConstStartIndex + JS_BLANKS_IMPORT.length(),
				importAsString.toString());

	}

	public String prepareJsImportLine(String key, String value) {
		String jsPath = prepareJsPath(key, value);
		String jsImportLine = "import " + key + " from " + "\"../" + jsPath + ".js\";\n";
		return jsImportLine;
	}

	private String prepareJsPath(String key, String value) {
		String path = value.substring(0, value.lastIndexOf("."));
		return path + "/" + key;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public void setSerializerPath(String serializerPath) {
		this.serializerPackageName = serializerPath;

	}

	public void setSerializerClazzName(String serializerClazzName) {
		this.serializerClazzName = serializerClazzName;
	}

}
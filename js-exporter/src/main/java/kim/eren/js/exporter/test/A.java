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
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
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
import com.github.javaparser.ast.type.ClassOrInterfaceType;
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
				// can we add Serializer name check here
				if (importPath.equals(getSerializerPackageName())) {
					return true;
				}
			}
		}
		return false;
	}

	public Map<String, String> getListOfImport(CompilationUnit unit) {
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

	public void prepareJsInfoList() throws IOException {
		for (Path p : clazzWhichContainsSerializer) {
			JsInfo jsInfo = new JsInfo();
			CompilationUnit unit = getCompileUnit(p.toFile());
			String packageName = unit.getPackage().getName().toString();
			jsInfo.setPackageName(packageName);
			Map<String, String> importList = getListOfImport(unit);
			extractClazzDeclarationLine(jsInfo, unit, importList);
			Map<String, ClazzContainer> propList = preparePropsList(unit, importList);
			jsInfo.setPropList(propList);
			prepareImportList(jsInfo);
			jsInfoList.add(jsInfo);

		}

	}

	private void prepareImportList(JsInfo jsInfo) {
		if (jsInfo.getParentClazzName() != null) {
			ClazzContainer parentClazzName = jsInfo.getParentClazzName();
			// if parent package name null? must be in same package;
			String packageName = parentClazzName.getPackageName();
			if (packageName == null) {
				packageName = jsInfo.getPackageName();
			}
			jsInfo.getImportList().put(parentClazzName.getName(), packageName);
		}
		if (!jsInfo.getPropList().isEmpty()) {
			for (String s : jsInfo.getPropList().keySet()) {
				ClazzContainer cContainer = jsInfo.getPropList().get(s);
				String clazzName = cContainer.getName();
				String packageName = cContainer.getPackageName();
				jsInfo.getImportList().put(clazzName, packageName);
			}
		}

	}

	private void extractClazzDeclarationLine(JsInfo jsInfo, CompilationUnit unit, Map<String, String> importList) {
		ClassOrInterfaceDeclaration type = getTypeDeclaration(unit);
		String name = getClazzName(type);
		jsInfo.setName(name);
		String parentName = getParentClazzName(type);
		ClazzContainer cContainer = new ClazzContainer();
		cContainer.setPackageName(importList.get(parentName));
		cContainer.setName(parentName);
		jsInfo.setParentClazzName(cContainer);

	}

	private String getParentClazzName(ClassOrInterfaceDeclaration type) {
		List<ClassOrInterfaceType> extendList = type.getExtends();
		ClassOrInterfaceType clazzType = extendList.get(0);
		return clazzType.getName();
	}

	private String getClazzName(ClassOrInterfaceDeclaration type) {
		return type.getName();
	}

	private ClassOrInterfaceDeclaration getTypeDeclaration(CompilationUnit unit) {
		List<TypeDeclaration> types = unit.getTypes();
		for (TypeDeclaration type : types) {
			if (type instanceof ClassOrInterfaceDeclaration) {
				return (ClassOrInterfaceDeclaration) type;
			}
		}
		return null;
	}

	private Map<String, ClazzContainer> preparePropsList(CompilationUnit unit, Map<String, String> importList) {
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
						Map<String, ClazzContainer> propList = findPropList(anonymousClassBodys, importList);
						return propList;
					}
				}

			}
		}
		return null;
	}

	public Map<String, ClazzContainer> findPropList(List<BodyDeclaration> bodyDecList, Map<String, String> importList) {
		Map<String, ClazzContainer> propList = new HashMap<>();
		for (BodyDeclaration bodyDeclaration : bodyDecList) {
			if (bodyDeclaration instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration) bodyDeclaration;
				if (ANONYMOUS_CLAZZ_METHOD_NAME.equals(method.getName())) {
					BlockStmt body = method.getBody();
					BodyExpressionVisitor bExpressionVisitor = new BodyExpressionVisitor();
					for (Node node : body.getChildrenNodes()) {
						List<Expression> bExpresionList = node.accept(bExpressionVisitor, null);
						String key = bExpresionList.get(0).toString();
						String variableName = key.substring(key.indexOf(".") + 1, key.length());
						String clazzName = bExpresionList.get(1).toString();
						String type = clazzName.substring(0, clazzName.indexOf("."));
						ClazzContainer cContainer = new ClazzContainer();
						cContainer.setName(type);
						cContainer.setPackageName(importList.get(type));
						propList.put(variableName, cContainer);
					}
				}
			}
		}
		return propList;
	}

	public void createJsFiles() {
		for (JsInfo jsInfo : jsInfoList) {
			// first create string files
			String jsClazzAsString = prepareJsClazzAsString(jsInfo);
			System.out.println("A.createJsFiles()" + jsClazzAsString);

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
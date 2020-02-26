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
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.InitializerDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

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

	@Override
	public boolean test(Path p) {
		boolean fileExtensionCorrect = false, fileHasSerializer = false;
		fileExtensionCorrect = p.toString().endsWith(".java");
		try {
			fileHasSerializer = findSerializer2(p.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileExtensionCorrect && fileHasSerializer;
	}

	public String getSerializerFullPath() {
		return serializerPackageName + "." + serializerClazzName;
	}

	public void prepareSerializerList() throws IOException {
		Files.walk(Paths.get(projectPath)).filter(this).forEach((e) -> clazzWhichContainsSerializer.add(e));
	}

	private boolean findSerializer(File f) {
		BufferedReader br = getBufferedReader(f);
		if (br != null) {
			String st;
			try {
				while ((st = br.readLine()) != null) {
					String[] strParts = st.split(" ");
					if (strParts.length > 1) {
						// we can add optimization here if not starts with imports count greater than 5
						// can be return false;
						Pattern pattern = Pattern.compile("import");
						Matcher m = pattern.matcher(strParts[0]);
						if (m.find()) {
							pattern = Pattern.compile(serializerPackageName);
							m = pattern.matcher(strParts[1]);
							boolean mResult = m.find();
							if (mResult) {
								return mResult && !st.contains("//") && !st.contains("/*");
							}

						}
					}
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
		}
		return false;
	}

	private BufferedReader getBufferedReader(File f) {
		try {
			return new BufferedReader(new FileReader(f));

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		}
		return null;
	}

	private static class MethodNamePrinter extends VoidVisitorAdapter<String> {
		@Override
		public void visit(ImportDeclaration md, String arg) {
			super.visit(md, arg);
			System.out.println("Method Name Printed: " + md.getName());
			arg = md.getName().getName();
		}

	}

	public boolean findSerializer2(File file) throws IOException {
		if (!file.isDirectory()) {
			CompilationUnit unit = getCompileUnit(file);
			List<ImportDeclaration> importList = unit.getImports();
			for (ImportDeclaration importDeclaration : importList) {
				String importFullPath = importDeclaration.getName().toString();
				if (importFullPath.equals(getSerializerFullPath())) {
					return true;
				}
			}
		}
		return false;
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
			CompilationUnit unit = getCompileUnit(p.toFile());
			List<TypeDeclaration> types = unit.getTypes();
			for (TypeDeclaration type : types) {
				List<BodyDeclaration> bodyDeclarations = type.getMembers();
				for (BodyDeclaration bodyDeclaration : bodyDeclarations) {
					if (bodyDeclaration instanceof MethodDeclaration) {
						MethodDeclaration method = (MethodDeclaration) bodyDeclaration;
						System.out.println("A.prepareJsInfoList2()");
					}

				}
			}

		}

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
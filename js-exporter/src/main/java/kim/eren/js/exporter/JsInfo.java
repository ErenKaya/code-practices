package kim.eren.js.exporter;

import java.util.HashMap;
import java.util.Map;

public class JsInfo {

	private String name;
	private String packageName;
	private Map<String, ClazzContainer> propList;
	private ClazzContainer parentClazzName;
	private Map<String, String> importList = new HashMap<String, String>();

	public JsInfo() {
		propList = new HashMap<String, ClazzContainer>();
		importList = new HashMap<String, String>();
	}

	public String getName() {
		return name;
	}

	public String getPackageName() {
		return packageName;
	}

	public Map<String, ClazzContainer> getPropList() {
		return propList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setPropList(Map<String, ClazzContainer> propList) {
		this.propList = propList;
	}

	public ClazzContainer getParentClazzName() {
		return parentClazzName;
	}

	public void setParentClazzName(ClazzContainer parentClazzName) {
		this.parentClazzName = parentClazzName;
	}

	public void addPropToList(String name, ClazzContainer clazzName) {
		this.propList.put(name, clazzName);
	}

	public void showObjectItself() {
		System.out.println(this.name + " " + this.parentClazzName + " " + this.packageName + " ");
	}

	public void setImportList(Map<String, String> importList) {
		this.importList = importList;
	}

	public Map<String, String> getImportList() {
		return importList;
	}

}

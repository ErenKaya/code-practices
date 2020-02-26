package kim.eren.js.exporter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import kim.eren.js.exporter.JsInfo;

public class ATest {
	A aInstance;

	@Before
	public void init() {
		aInstance = new A();
	}

	@Test
	public void test_serializer_finder_method() throws IOException {
		assertTrue(aInstance.findSerializer2(new File(
				"../code-practices/oca-8-certificate/src/main/java/kim/eren/oca_8_certificate/core/gk/model/ParentModelObject.java")));
	}

	@Test
	public void test_package_name_line_parser() {
		assertEquals("kim.eren.oca_8_certificate.core.gk.model",
				aInstance.getPackageNameFromLine("package kim.eren.oca_8_certificate.core.gk.model;"));
	}

	@Test
	public void test_name_line_parser() {
		assertEquals("ModelObject", aInstance.getNameFromLine("public class ModelObject {"));
	}

	@Test
	public void test_check_prop_addder() throws ClassNotFoundException {
		JsInfo jsInfo = new JsInfo();
		aInstance.setPropToList("s.get(m.getVariable(), String.class);", jsInfo);
	}

	@Test
	public void test_parent_clazz_name_parser() {
		assertEquals("ModelObjectParent",
				aInstance.findExtendedClazzName("public class ModelObject extends ModelObjectParent {"));
	}

	@Test
	public void test_import_line_parser() {
		assertEquals("kim.eren.oca_8_certificate.core.gk.serializer.Serializer",
				aInstance.parseImportLine("import kim.eren.oca_8_certificate.core.gk.serializer.Serializer;"));
	}

	@Test
	public void test_clazz_name_from_import_value() {
		assertEquals("Serializer",
				aInstance.parseClazzNameFromImport("kim.eren.oca_8_certificate.core.gk.serializer.Serializer"));
	}

	@Test
	public void test_js_import_path() {
		assertEquals("import CustomProp from \"../kim.eren.oca_8_certificate.core.gk.prop/CustomProp.js\";",
				aInstance.prepareJsImportLine("CustomProp", "kim.eren.oca_8_certificate.core.gk.prop.CustomProp"));
	}

}

package kim.eren.js.exporter;

import java.io.IOException;

import kim.eren.js.exporter.test.A;

public class App {
	public static void main(String[] args) throws IOException {
		A a = new A();
		a.setProjectPath(
				"/home/eren/eclipse-workspace/code-practices/oca-8-certificate/src/main/java/kim/eren/oca_8_certificate/core/gk");
		a.setSerializerPath("kim.eren.oca_8_certificate.core.gk.serializer");
		a.setSerializerClazzName("Serializer");
		a.prepareSerializerList();
		a.prepareJsInfoList();
		a.prepareJsInfoList2();
		a.createJsFiles();
	}

}

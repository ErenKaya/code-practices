package io.erenkaya.oacar._4_chapter.value;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("oacar\\bean4.xml");

		JavaHome jHome = context.getBean("javaHome", JavaHome.class);
		System.out.println(jHome);
		context.close();
	}

}

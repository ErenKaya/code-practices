package io.erenkaya.akaldiroglu._06_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import io.erenkaya.akaldiroglu._06_example.domain.Person;

public class ApplicationXmlContainer {
	public static void main(String[] args) {
		t1();
//		t2();
	}

	public static void t1() {

		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "office");
		String path = "bean5.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		Person person = (Person) factory.getBean("person");
		System.out.println(person);
	}

	public static void t2() {

		String path = "bean5.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		Person person = (Person) factory.getBean("person");
		System.out.println(person);

	}
}

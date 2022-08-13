package io.erenkaya.akaldiroglu._06_example.conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.akaldiroglu._06_example.conditional.domain.BeanA;

public class Application {

	public static void main(String args[]) {

		String path = "bean5.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		BeanA person = (BeanA) factory.getBean("beanA");
		System.out.println(person);
	}

}

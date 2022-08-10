package io.erenkaya.akaldiroglu._04_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.akaldiroglu._04_example.domain.GreetingRenderer;


public class ApplicationXmlContainer {
	public static void main(String[] args) {
		String path = "bean3.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		GreetingRenderer renderer = (GreetingRenderer) factory.getBean("renderer2");
		renderer.render();

	}
}

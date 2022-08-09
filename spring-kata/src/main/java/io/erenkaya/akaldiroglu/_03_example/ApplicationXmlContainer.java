package io.erenkaya.akaldiroglu._03_example;

import io.erenkaya.akaldiroglu._01_example.domain.GreetingRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXmlContainer {
	public static void main(String[] args) {
		String path = "bean2.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		GreetingRenderer renderer = (GreetingRenderer) factory.getBean("renderer");
		renderer.render();

	}
}

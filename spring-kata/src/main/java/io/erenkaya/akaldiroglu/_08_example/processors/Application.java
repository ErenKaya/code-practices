package io.erenkaya.akaldiroglu._08_example.processors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		System.err.println(context.getBean("beanA"));
		System.err.println(context.getBean("beanB"));
		System.err.println(context.getBean("beanC"));
		System.err.println(context.getBean("beanD"));
		context.close();
	}
}

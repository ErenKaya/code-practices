package io.erenkaya.oacar._4_chapter.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		CarFactory carFactory = context.getBean("carFactory", CarFactory.class);
		System.out.println(carFactory);
		context.close();
	}

}

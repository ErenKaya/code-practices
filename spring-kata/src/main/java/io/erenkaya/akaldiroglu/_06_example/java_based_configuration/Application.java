package io.erenkaya.akaldiroglu._06_example.java_based_configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.erenkaya.akaldiroglu._06_example.java_based_configuration.configuration.Configuration1;
import io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain.BeanA;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Configuration1.class);
		context.refresh();
		BeanA beanA = context.getBean(BeanA.class);
		System.out.println(beanA);
	}

}

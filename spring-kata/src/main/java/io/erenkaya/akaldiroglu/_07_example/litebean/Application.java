package io.erenkaya.akaldiroglu._07_example.litebean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.erenkaya.akaldiroglu._07_example.litebean.a.BeanA;
import io.erenkaya.akaldiroglu._07_example.litebean.b.BeanB;

@ComponentScan("io.erenkaya.akaldiroglu._07_example.litebean.b")
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//		executeA(context);
		executeB(context);
	}

	private static void executeB(AnnotationConfigApplicationContext context) {
		BeanB b = context.getBean(BeanB.class);
		System.out.println(b);

	}

	private static void executeA(AnnotationConfigApplicationContext context) {
		BeanA a = context.getBean(BeanA.class);
		System.out.println(a);
	}
}

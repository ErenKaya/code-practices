package io.erenkaya.akaldiroglu._08_example.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.erenkaya.akaldiroglu._08_example.lazy.domain.BeanA;
import io.erenkaya.akaldiroglu._08_example.lazy.domain.BeanC;

@ComponentScan("io.erenkaya.akaldiroglu._08_example.lazy")
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		BeanA bean = context.getBean(BeanA.class);
	}

}

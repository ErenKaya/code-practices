package io.erenkaya.akaldiroglu.aop.sqrt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.erenkaya.akaldiroglu.aop.sqrt.domain.Calculator;

@ComponentScan
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Calculator calc = (Calculator) context.getBean("factoryBean");
		calc.calculate(16);
		context.close();
	}

}

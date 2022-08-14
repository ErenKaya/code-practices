package io.erenkaya.akaldiroglu._07_example.ex.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.erenkaya.akaldiroglu._07_example.ex.Calculator;
import io.erenkaya.akaldiroglu._07_example.ex.conf.Configuration1;

public class CalculatorApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext();
		factory.register(Configuration1.class);
		factory.refresh();
		Calculator calculator = (Calculator) factory.getBean("calculator");
		System.out.println(calculator.doCalculation("Sin", 2 * Math.PI * 30 / 360));
		System.out.println(calculator.doCalculation("Cos", 2 * Math.PI * 30 / 360));
		System.out.println(calculator.doCalculation("Log", 2.71828));
	}
}

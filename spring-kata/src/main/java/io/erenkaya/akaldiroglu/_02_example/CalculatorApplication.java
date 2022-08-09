package io.erenkaya.akaldiroglu._02_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.akaldiroglu._01_example.domain.GreetingRenderer;

public class CalculatorApplication {
	public static void main(String[] args) {
		String path = "bean.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
		Calculator calculator = (Calculator) factory.getBean("calculator");
		System.out.println(calculator.doCalculation("Sin", 2 * Math.PI * 30 / 360));
		System.out.println(calculator.doCalculation("Cos", 2 * Math.PI * 30 / 360));
		System.out.println(calculator.doCalculation("Log", 2.71828));
	}
}

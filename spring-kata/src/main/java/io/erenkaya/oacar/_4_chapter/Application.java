package io.erenkaya.oacar._4_chapter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.oacar._4_chapter.domain.Car;

public class Application {
	public static void main(String[] args) {
		String path = "oacar\\bean3.xml";
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(path);

		String[] beanNames = factory.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			if (!beanName.equals("abstractCar")) {
				Object bean = factory.getBean(beanName);
				if (bean instanceof Car) {
					Car localC = (Car) bean;
					System.out.println(localC);
				}
			}
		}
		factory.close();
	}
}

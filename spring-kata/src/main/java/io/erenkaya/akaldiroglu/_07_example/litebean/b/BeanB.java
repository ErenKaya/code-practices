package io.erenkaya.akaldiroglu._07_example.litebean.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

	private String name;
	private int age;
	private BeanC beanC;

	@Autowired
	public BeanB(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Autowired
	public void setBeanC(BeanC beanC) {
		this.beanC = beanC;
	}
	
	@Bean
	public BeanC beanC() {
		return new BeanC();
	}

	@Bean
	public static String name() {
		return "Bean-A";
	}

	@Bean
	public static int age() {
		return 17;
	}

	@Bean
	@Qualifier("x")
	public String beanCName() {
		return "Bean - C";
	}

	@Override
	public String toString() {
		return "BeanB[age=" + this.age + " name = " + this.name + " beanC= " + this.beanC + "]";
	}

}

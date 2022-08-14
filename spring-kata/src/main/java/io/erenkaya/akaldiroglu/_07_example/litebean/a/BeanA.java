package io.erenkaya.akaldiroglu._07_example.litebean.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * LiteBean used with static keyword if you declare in constructor of class.
 * 
 * @author erenk
 *
 */
@Component
public class BeanA {

	private String name;
	private int age;

	@Autowired
	public BeanA(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Bean
	public static String name() {
		return "Bean-A";
	}

	@Bean
	public static int age() {
		return 17;
	}

	@Override
	public String toString() {
		return "BeanA[age=" + this.age + " name = " + this.name + "]";
	}

}

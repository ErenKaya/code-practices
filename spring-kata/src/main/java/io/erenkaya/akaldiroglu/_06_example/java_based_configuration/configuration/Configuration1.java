package io.erenkaya.akaldiroglu._06_example.java_based_configuration.configuration;

import org.springframework.context.annotation.Bean;

import io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain.BeanA;
import io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain.BeanB;
import io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain.BeanC;

public class Configuration1 {

	@Bean
	public BeanA getBeanA() {
		return new BeanA();
	}

	@Bean
	public BeanB getBeanB(String name, String age) {
		return new BeanB(name, age);
	}

	@Bean
	public String name() {
		return "Eren";
	}

	@Bean
	public String age() {
		return "29";
	}

	@Bean
	public BeanC getBeanC() {
		return new BeanC();
	}

	@Bean
	public String nameOfBeanC() {
		return "Bean C";
	}
}

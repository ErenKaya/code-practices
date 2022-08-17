package io.erenkaya.akaldiroglu._08_example.life_cycle_methods.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanC {
	@Autowired
	private String nameOfBeanC;

	public BeanC() {
		System.err.println("In BeanC");
	}

	@Override
	public String toString() {
		return String.format("BeanC=[%s]", this.nameOfBeanC);
	}

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct! BeanC");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("PreDestroy! BeanC");
	}
}

package io.erenkaya.akaldiroglu._08_example.life_cycle_methods.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BeanA {
	@Autowired
	private String name;
	@Autowired
	private String age;
	private BeanB beanB;

	public BeanA() {
		System.err.println("In BeanA");
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public BeanB getBeanB() {
		return beanB;
	}

	@Autowired
	public void setBeanB(@Lazy BeanB beanB) {
		this.beanB = beanB;
	}

	@Override
	public String toString() {
		return String.format("BeanA=[name=%s, age=%s, beanB=%s]", this.name, this.age, this.beanB);
	}

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct! BeanA");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("PreDestroy! BeanA");
	}

}

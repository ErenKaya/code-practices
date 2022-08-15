package io.erenkaya.akaldiroglu._08_example.lazy.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BeanA {
	@Autowired
	private String name;
	@Autowired
	private String age;
	private BeanB beanB;

	@Autowired
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

}

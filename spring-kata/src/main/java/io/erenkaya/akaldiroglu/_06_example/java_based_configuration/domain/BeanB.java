package io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanB {

	private String name;
	private String age;
	private BeanC beanC;

	@Autowired
	public BeanB(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public BeanC getBeanC() {
		return beanC;
	}

	@Autowired
	public void setBeanC(BeanC beanC) {
		this.beanC = beanC;
	}

	@Override
	public String toString() {
		return String.format("BeanB=[name=%s, age=%s, beanC=%s]", this.name, this.age, this.beanC);
	}

}

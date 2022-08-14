package io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanA {

	private BeanB beanB;

	@Autowired
	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}

	@Override
	public String toString() {
		return String.format("BeanA=[%s]", this.beanB);
	}

	public BeanB getBeanB() {
		return beanB;
	}

}

package io.erenkaya.akaldiroglu._08_example.lazy.domain;

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
}

package io.erenkaya.akaldiroglu._06_example.java_based_configuration.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanC {

	private String nameOfBeanC;

	public String getNameOfBeanC() {
		return nameOfBeanC;
	}

	@Autowired
	public void setNameOfBeanC(String nameOfBeanC) {
		this.nameOfBeanC = nameOfBeanC;
	}

	@Override
	public String toString() {
		return String.format("BeanC=[%s]", this.nameOfBeanC);
	}

}

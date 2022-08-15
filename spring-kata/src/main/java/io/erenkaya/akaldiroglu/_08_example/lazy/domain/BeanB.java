package io.erenkaya.akaldiroglu._08_example.lazy.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BeanB {

	private BeanC beanC;

	public BeanB() {
		System.err.println("In BeanB");
	}

	@Autowired
	public void setBeanC(@Lazy BeanC beanC) {
		this.beanC = beanC;
	}

	@Override
	public String toString() {
		return String.format("BeanB=[%s]", this.beanC);
	}

}

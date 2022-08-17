package io.erenkaya.akaldiroglu._08_example.life_cycle_methods.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct! BeanB");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("PreDestroy! BeanB");
	}

}

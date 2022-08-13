package io.erenkaya.akaldiroglu._06_example.conditional.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class BeanA {
	@Autowired
	@BeanBActivator
	private BeanB beanB;

	public BeanB getBeanB() {
		return beanB;
	}

}

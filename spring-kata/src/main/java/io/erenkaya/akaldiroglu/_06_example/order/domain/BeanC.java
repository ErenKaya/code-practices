package io.erenkaya.akaldiroglu._06_example.order.domain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BeanC implements Bean {

	public BeanC() {
		super();
		System.err.println("BeanC cons");
	}

}

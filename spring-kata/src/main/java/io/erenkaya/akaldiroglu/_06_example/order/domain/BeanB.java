package io.erenkaya.akaldiroglu._06_example.order.domain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class BeanB implements Bean {

	public BeanB() {
		super();
		System.err.println("BeanB cons");
	}

}

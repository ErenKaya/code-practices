package io.erenkaya.akaldiroglu._06_example.order.domain;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order( Ordered.LOWEST_PRECEDENCE)
public class BeanA implements Bean {

	public BeanA() {
		super();
		System.err.println("BeanA cons");
	}

}

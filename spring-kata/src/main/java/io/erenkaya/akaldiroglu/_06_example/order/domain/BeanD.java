package io.erenkaya.akaldiroglu._06_example.order.domain;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeanD implements Bean {

	public BeanD() {
		super();
		System.err.println("BeanD cons");
	}

}

package io.erenkaya.akaldiroglu._07_example.litebean.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanC {
	@Autowired
	@Qualifier("x")
	private String nameOfBeanC;

	@Override
	public String toString() {
		return "BeanC[" + " name = " + this.nameOfBeanC + "]";
	}
}

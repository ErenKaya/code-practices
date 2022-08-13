package io.erenkaya.akaldiroglu._06_example.conditional.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(BeanBCondition.class)
@BeanBActivator
public class BeanB {

	@Autowired
	private BeanC beanC;

	public BeanC getBeanC() {
		return beanC;
	}

}

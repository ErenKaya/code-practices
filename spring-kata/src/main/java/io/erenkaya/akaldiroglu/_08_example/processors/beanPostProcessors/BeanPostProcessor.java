package io.erenkaya.akaldiroglu._08_example.processors.beanPostProcessors;

import java.time.LocalDateTime;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import io.erenkaya.akaldiroglu._08_example.processors.domain.ProBean;

@Component
public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("beanA".equals(beanName)) {
			((ProBean) bean).preProcessesDate(LocalDateTime.now());
		} else if ("beanB".equals(beanName) || "beanC".equals(beanName)) {
			((ProBean) bean).setName("AnotherName");
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("beanA".equals(beanName)) {
			((ProBean) bean).afterProcessesDate(LocalDateTime.now());
		} else if ("beanB".equals(beanName) || "beanC".equals(beanName)) {
			((ProBean) bean).setName("AnotherName2");
		}
		return bean;
	}
}

package io.erenkaya.akaldiroglu._08_example.processors;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorEx implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int beanCount = beanFactory.getBeanDefinitionCount();

		System.err.println(String.format("There are %d beans registered", beanCount));
		System.err.println("Here are they");
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(System.out::println);

//		Arrays.stream(beanNames).forEach(name -> System.out.println(beanFactory.getBean(name)));
	}

}

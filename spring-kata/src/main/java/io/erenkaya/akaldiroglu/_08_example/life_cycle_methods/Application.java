package io.erenkaya.akaldiroglu._08_example.life_cycle_methods;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.erenkaya.akaldiroglu._08_example.life_cycle_methods.domain.*;

/**
 * Post construct method call back when Spring intialize all of member of bean
 * 
 * @author erenk
 *
 */
@ComponentScan
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		BeanA bean = context.getBean(BeanA.class);
		for (String beanName : context.getBeanDefinitionNames()) {
			context.removeBeanDefinition(beanName);
		}
		System.out.println(bean);
	}

}

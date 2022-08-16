package io.erenkaya.akaldiroglu._06_example.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import io.erenkaya.akaldiroglu._06_example.order.domain.Bean;

/**
 * Order related with order of arrays its not related with class loading cycle
 * 
 * @author erenk
 *
 */
@ComponentScan
public class OrderApplication {
	@Autowired
	List<Bean> beans;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OrderApplication.class);
		OrderApplication application = (OrderApplication) context.getBean("orderApplication");
		application.beans.forEach((e) -> System.out.println(e));
	}
}

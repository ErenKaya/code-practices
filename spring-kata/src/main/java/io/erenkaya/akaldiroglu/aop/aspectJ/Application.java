package io.erenkaya.akaldiroglu.aop.aspectJ;

import java.util.stream.Stream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.erenkaya.akaldiroglu.aop.aspectJ.domain.Greeter;
import io.erenkaya.akaldiroglu.aop.aspectJ.ex.NotGoodNameException;

@ComponentScan
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) throws NotGoodNameException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		Greeter greeter = (Greeter) context.getBean("arabicGreeter");
		greeter.greet("Eren");
	}

}

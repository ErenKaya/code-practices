package io.erenkaya.akaldiroglu.aop.greeting;

import org.springframework.aop.framework.ProxyFactory;

import io.erenkaya.akaldiroglu.aop.greeting.advice.*;

public class Application {
	public static void main(String[] args) {
		Greeting greeting = new Hello();

//		setTarget(greeting);
//		runBeforeAdvice(greeting);
//		runAfterAdvice(greeting);
		runAroundAdvice(greeting);
	}

	private static void runAroundAdvice(Greeting greeting) {
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new AroundAdvice());
		factory.setTarget(greeting);
		Greeting greeting2 = (Greeting) factory.getProxy();
		greeting2.greet();
		
	}

	private static void runAfterAdvice(Greeting greeting) {
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new AfterAdvice());
		factory.setTarget(greeting);
		Greeting greeting2 = (Greeting) factory.getProxy();
		greeting2.greet();
		
	}

	private static void runBeforeAdvice(Greeting greeting) {
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new BeforeAdvice());
		factory.setTarget(greeting);
		Greeting greeting2 = (Greeting) factory.getProxy();
		greeting2.greet();

	}

	private static void setTarget(Greeting greeting) {
		greeting.greet();
	}

}

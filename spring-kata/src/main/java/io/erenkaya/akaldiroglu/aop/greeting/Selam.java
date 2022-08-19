package io.erenkaya.akaldiroglu.aop.greeting;

public class Selam implements Greeting {

	@Override
	public void greet() {
		System.out.println("Selam");
	}

}

package io.erenkaya.akaldiroglu.aop.aspectJ.domain;

import io.erenkaya.akaldiroglu.aop.aspectJ.ex.NotGoodNameException;

public class ArabicGreeter implements Greeter {

	@Override
	public void greet(String name) throws NotGoodNameException {
		System.out.println("أهلا " + name);
	}

}

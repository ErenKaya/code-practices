package io.erenkaya.akaldiroglu.aop.aspectJ.domain;

import io.erenkaya.akaldiroglu.aop.aspectJ.ex.NotGoodNameException;

public interface Greeter {

	public void greet(String name) throws NotGoodNameException;

}

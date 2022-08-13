package io.erenkaya.akaldiroglu._06_example.domain;

public abstract class HomeAddress implements Address {

	@Override
	public String toString() {
		return this.getAddress();
	}

}

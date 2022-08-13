package io.erenkaya.akaldiroglu._06_example.profile.domain;

public abstract class HomeAddress implements Address {

	@Override
	public String toString() {
		return this.getAddress();
	}

}

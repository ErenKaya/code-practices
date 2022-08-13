package io.erenkaya.akaldiroglu._06_example.profile.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

	@Autowired
	public Address address;

	@Override
	public String toString() {
		return "Person[" + address.toString() + "]";
	}
}

package io.erenkaya.akaldiroglu._06_example.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("address")
@Profile("office")
public class OfficeAddress implements Address {

	@Override
	public String getAddress() {
		return "Office Address";
	}

	@Override
	public String toString() {
		return this.getAddress();
	}

}

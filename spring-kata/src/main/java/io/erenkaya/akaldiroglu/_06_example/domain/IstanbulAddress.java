package io.erenkaya.akaldiroglu._06_example.domain;

import org.springframework.stereotype.Component;

@Component
public class IstanbulAddress extends HomeAddress {

	@Override
	public String getAddress() {
		return "IstanbulAddress";
	}

}

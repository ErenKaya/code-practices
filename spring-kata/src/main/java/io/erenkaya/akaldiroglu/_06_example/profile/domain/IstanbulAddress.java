package io.erenkaya.akaldiroglu._06_example.profile.domain;

import org.springframework.stereotype.Component;

@Component
public class IstanbulAddress extends HomeAddress {

	@Override
	public String getAddress() {
		return "IstanbulAddress";
	}

}

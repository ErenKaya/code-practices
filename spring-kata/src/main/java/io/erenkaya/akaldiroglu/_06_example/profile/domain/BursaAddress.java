package io.erenkaya.akaldiroglu._06_example.profile.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("address")
@Profile("home")
public class BursaAddress extends HomeAddress{
	
	@Override
	public String getAddress() {
		return "Bursa Address";
	}
}

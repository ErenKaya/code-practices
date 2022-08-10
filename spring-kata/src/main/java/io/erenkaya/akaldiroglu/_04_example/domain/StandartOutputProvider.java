package io.erenkaya.akaldiroglu._04_example.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "provider1")
@Qualifier("standart")
public class StandartOutputProvider implements GreetingProvider {

	private String greeting = "Hello World!";

	@Override
	public String getGreeting() {
		return greeting;
	}
}

package io.erenkaya.akaldiroglu._04_example.domain;

import org.springframework.stereotype.Component;

@Component(value = "provider1")
public class StandartOutputProvider implements GreetingProvider {

	private String greeting = "Hello World!";

	@Override
	public String getGreeting() {
		return greeting;
	}
}

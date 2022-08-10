package io.erenkaya.akaldiroglu._04_example.domain;

//@Component(value = "provider2")
public class ErrorOutputProvider implements GreetingProvider {
	@Override
	public String getGreeting() {
		return "There is an issue";
	}
}

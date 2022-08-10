package io.erenkaya.akaldiroglu._04_example.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "provider2")
@Qualifier("errorProvider")
public class ErrorOutputProvider implements GreetingProvider {
	@Override
	public String getGreeting() {
		return "There is an issue";
	}
}

package io.erenkaya.akaldiroglu._04_example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "renderer2")
public class ErrorOutputRenderer implements GreetingRenderer {
	@Autowired
	@Qualifier("errorProvider")
	private GreetingProvider provider;

	@Override
	public void setProvider(GreetingProvider provider) {
		this.provider = provider;
	}

	@Override
	public void render() {
		System.err.println(this.provider.getGreeting());
	}
}

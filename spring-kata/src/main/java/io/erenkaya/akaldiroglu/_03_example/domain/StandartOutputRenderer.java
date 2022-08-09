package io.erenkaya.akaldiroglu._03_example.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class StandartOutputRenderer implements GreetingRenderer {
	
	@Autowired
	private GreetingProvider provider;

	@Override
	public void setProvider(GreetingProvider provider) {
		this.provider = provider;
	}

	@Override
	public void render() {
		String message = this.provider.getGreeting();
		System.out.println(message);
	}
}
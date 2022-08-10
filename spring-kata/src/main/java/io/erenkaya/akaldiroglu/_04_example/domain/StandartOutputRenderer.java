package io.erenkaya.akaldiroglu._04_example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "renderer1")
public class StandartOutputRenderer implements GreetingRenderer {

	@Autowired
	@Qualifier("standart")
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
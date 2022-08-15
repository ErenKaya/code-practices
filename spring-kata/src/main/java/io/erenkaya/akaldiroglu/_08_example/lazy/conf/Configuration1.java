package io.erenkaya.akaldiroglu._08_example.lazy.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.erenkaya.akaldiroglu._08_example.lazy.domain.BeanA;
import io.erenkaya.akaldiroglu._08_example.lazy.domain.BeanB;
import io.erenkaya.akaldiroglu._08_example.lazy.domain.BeanC;

@Lazy
@Configuration
public class Configuration1 {

	@Bean
	public BeanB getBeanB() {
		return new BeanB();
	}

	@Bean
	public BeanA getBeanA() {
		return new BeanA();
	}

	@Bean
	public BeanC getBeanC() {
		return new BeanC();
	}

	@Bean
	public String name() {
		return "Eren";
	}

	@Bean
	public String age() {
		return "29";
	}

	@Bean
	public String nameOfBeanC() {
		return "Bean CF";
	}
}

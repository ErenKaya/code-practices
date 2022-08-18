package io.erenkaya.akaldiroglu._08_example.processors.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.erenkaya.akaldiroglu._08_example.processors.domain.BeanA;
import io.erenkaya.akaldiroglu._08_example.processors.domain.BeanB;
import io.erenkaya.akaldiroglu._08_example.processors.domain.BeanC;
import io.erenkaya.akaldiroglu._08_example.processors.domain.BeanD;

@Configuration
public class AppConfig {

	@Bean
	public BeanA beanA() {
		return new BeanA();
	}

	@Bean
	public BeanB beanB() {
		return new BeanB();
	}

	@Bean
	public BeanC beanC() {
		return new BeanC();
	}

	@Bean
	public BeanD beanD() {
		return new BeanD();
	}

	@Bean
	public String name() {
		return "A_Bean";
	}

}

package io.erenkaya.akaldiroglu.aop.aspectJ.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.erenkaya.akaldiroglu.aop.aspectJ.domain.ArabicGreeter;
import io.erenkaya.akaldiroglu.aop.aspectJ.domain.EnglishGreeter;
import io.erenkaya.akaldiroglu.aop.aspectJ.domain.Greeter;
import io.erenkaya.akaldiroglu.aop.aspectJ.domain.TurkishGreeter;

@Configuration
@Lazy
public class ApplicationConfiguration {

	@Bean
	public Greeter arabicGreeter() {
		return new ArabicGreeter();
	}

	@Bean
	public Greeter turkishGreeter() {
		return new TurkishGreeter();
	}

	@Bean
	public Greeter englishGreeter() {
		return new EnglishGreeter();
	}

}

package io.erenkaya.akaldiroglu.aop.aspectJ.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.erenkaya.akaldiroglu.aop.aspectJ.advices.AfterAspect;
import io.erenkaya.akaldiroglu.aop.aspectJ.advices.AfterThrowingAspect;
import io.erenkaya.akaldiroglu.aop.aspectJ.advices.AroundAspect;
import io.erenkaya.akaldiroglu.aop.aspectJ.advices.BeforeAspect;

@Configuration
@Lazy
public class AOPConfiguration {

	@Bean(name = "aroundAspect")
	public AroundAspect getAroundAspect() {
		AroundAspect a = new AroundAspect();
		return a;
	}

	@Bean(name = "afterThrowingAspect")
	public AfterThrowingAspect getAfterThrowingAspect() {
		return new AfterThrowingAspect();
	}

	@Bean(name = "afterAspect")
	public AfterAspect getAfterAspect() {
		return new AfterAspect();
	}

	@Bean(name = "beforeAspect")
	public BeforeAspect getBeforeAspect() {
		return new BeforeAspect();
	}

}

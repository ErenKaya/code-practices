package io.erenkaya.akaldiroglu.aop.sqrt.conf;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.erenkaya.akaldiroglu.aop.sqrt.advice.AfterAdvice;
import io.erenkaya.akaldiroglu.aop.sqrt.advice.AroundAdvice;
import io.erenkaya.akaldiroglu.aop.sqrt.advice.BeforeAdvice;
import io.erenkaya.akaldiroglu.aop.sqrt.domain.Calculator;
import io.erenkaya.akaldiroglu.aop.sqrt.impl.MathSqrtCalculator;
import io.erenkaya.akaldiroglu.aop.sqrt.impl.NewtonRaphsonMethod;

@Configuration
public class SqrtConfiguration {

	@Bean
	public AfterAdvice afterAdvice() {
		return new AfterAdvice();
	}

	@Bean
	public AroundAdvice aroundAdvice() {
		return new AroundAdvice();
	}

	@Bean
	public BeforeAdvice beforeAdvice() {
		return new BeforeAdvice();
	}

	@Bean
	public Calculator mathSqrtCalculator() {
		return new MathSqrtCalculator();
	}

	@Bean
	public Calculator newtonCalculator() {
		return new NewtonRaphsonMethod();
	}

	@Bean
	public ProxyFactoryBean factoryBean() {
		ProxyFactoryBean factorProxyFactoryBean = new ProxyFactoryBean();
//		factorProxyFactoryBean.setInterceptorNames(new String[] { "afterAdvice", "aroundAdvice", "beforeAdvice" });
//		factorProxyFactoryBean.setInterceptorNames(new String[] { "afterAdvice" });
		factorProxyFactoryBean.setInterceptorNames(new String[] { "aroundAdvice" });
//		factorProxyFactoryBean.setInterceptorNames(new String[] { "beforeAdvice" });
		factorProxyFactoryBean.setTargetName("mathSqrtCalculator");
		return factorProxyFactoryBean;
	}

}

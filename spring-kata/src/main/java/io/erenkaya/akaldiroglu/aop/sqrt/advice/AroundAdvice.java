package io.erenkaya.akaldiroglu.aop.sqrt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("Eren ");
		Object o = invocation.proceed();
		System.out.print(o);
		System.out.print(", Naber");
		return o;
	}

}

package io.erenkaya.akaldiroglu.aop.aspectJ.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterAspect {

//	@After("execution(* *.greet(..))")
	public void callAfter(JoinPoint joinPoint) {
		System.out.println();

		try {
			System.out.println("AfterAspect: the method name is " + joinPoint.getSignature().getName());
		} catch (IllegalArgumentException e) {
			System.out.println("AfterAspect: exception thrown" + e.getMessage());
		}
	}
}

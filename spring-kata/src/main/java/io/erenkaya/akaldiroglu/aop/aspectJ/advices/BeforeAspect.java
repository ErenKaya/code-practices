package io.erenkaya.akaldiroglu.aop.aspectJ.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAspect {

//	@Before("execution(* *.greet(..))")
	public void callAfter(JoinPoint joinPoint) {
		System.out.println();

		try {
			System.out.println("BeforeAspect: the method name is " + joinPoint.getSignature().getName());
		} catch (IllegalArgumentException e) {
			System.out.println("BeforeAspect: exception thrown" + e.getMessage());
		}
	}
}

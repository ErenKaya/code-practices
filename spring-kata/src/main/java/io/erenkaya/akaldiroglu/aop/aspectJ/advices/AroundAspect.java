package io.erenkaya.akaldiroglu.aop.aspectJ.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Lazy;

@Aspect
public class AroundAspect {

	@Around("execution(* *.greet(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around Aspect begins: " + joinPoint.getSignature().getName());
		try {
			Object o = joinPoint.proceed();
			System.out.println("Around Aspect ended: " + joinPoint.getSignature().getName());
			return o;
		} catch (IllegalArgumentException e) {
			System.out.println("AfterAspect: exception thrown" + e.getMessage());
			throw e;
		}
	}

}

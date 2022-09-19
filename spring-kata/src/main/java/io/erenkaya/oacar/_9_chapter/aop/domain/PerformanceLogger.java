package io.erenkaya.oacar._9_chapter.aop.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLogger {

	@Around("execution(*io.erenkaya.oacar._9_chapter.RentalServiceImpl.rentACar(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("Method öncesi:" + pjp.getSignature());
		Object o = pjp.proceed();
		System.out.println("Method sonrası:");
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Method koşturma süresi: " + elapsedTime + " miliseconds ");
		return o;
	}

}

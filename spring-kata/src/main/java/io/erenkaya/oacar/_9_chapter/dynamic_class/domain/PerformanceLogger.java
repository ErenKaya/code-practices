package io.erenkaya.oacar._9_chapter.dynamic_class.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLogger {
	
	@Around("execution(* io.erenkaya.oacar._9_chapter.aop.domain.RentalServiceImpl.rentACar(..))")
	public Object doAction(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("Process Begun");
		Object o = pjp.proceed();
		System.out.println("Process End: timeMillis" + (System.currentTimeMillis() - start));
		return o;
	}
}

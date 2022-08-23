package io.erenkaya.akaldiroglu.aop.aspectJ.advices;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import io.erenkaya.akaldiroglu.aop.aspectJ.ex.NotGoodNameException;

@Aspect
public class AfterThrowingAspect {

//	@AfterThrowing(pointcut = "execution(* *.greet(..))", throwing = "ex")
	public void afterThrowingException(NotGoodNameException ex) throws Exception {
		System.out.println("exception thrown Its: " + ex);
	}
}

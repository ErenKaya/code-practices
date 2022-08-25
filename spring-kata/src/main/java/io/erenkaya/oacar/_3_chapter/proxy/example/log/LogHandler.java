package io.erenkaya.oacar._3_chapter.proxy.example.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import io.erenkaya.oacar._3_chapter.proxy.example.RentalService;

public class LogHandler implements InvocationHandler {

	private RentalService service;

	public LogHandler(RentalService service) {
		super();
		this.service = service;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		System.out.println("Invoking method: " + method.getName());
		Object result = method.invoke(this.service, args);
		long end = System.nanoTime();
		
		System.out.println("Done in: "+ (end-start) + " ns.");
		return result;
	}

}

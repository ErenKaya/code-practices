package io.erenkaya.oacar._1_chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageManager {

	@Autowired
	private HelloWorldService service;

	public void printMessage() {
		System.out.println(service.getMessage());
	}

}

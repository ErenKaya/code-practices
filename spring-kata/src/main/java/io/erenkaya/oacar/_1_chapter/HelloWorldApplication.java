package io.erenkaya.oacar._1_chapter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HelloWorldApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				HelloWorldApplication.class);
		MessageManager manager = (MessageManager) context.getBean("messageManager");
		manager.printMessage();
		context.close();

	}

	@Bean
	public HelloWorldService service() {
		return new HelloWorldServiceImpl();
	}

}

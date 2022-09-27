package io.erenkaya.oacar._10_chapter.mvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar.domain.entities.Car;

@ComponentScan
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Car car = new Car("Ford Kuga");
		CarRepository service = (CarRepository) context.getBean("carRepositoryImpl");
		service.save(car);
		Car car2 = service.getCustomerByModel("Ford Kuga");
		context.close();
	}
}

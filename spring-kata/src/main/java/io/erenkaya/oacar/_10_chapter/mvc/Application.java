package io.erenkaya.oacar._10_chapter.mvc;

import java.text.ParseException;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar._10_chapter.mvc.dao.CustomerRepository;
import io.erenkaya.oacar.domain.entities.Car;
import io.erenkaya.oacar.domain.entities.Customer;

@ComponentScan
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) throws ParseException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		test_car_persistence(context);
		test_customer_persistence(context);
		context.close();
	}

	private static void test_customer_persistence(AnnotationConfigApplicationContext context) throws ParseException {
		Customer customer = new Customer("Kaya", 22, "Eren");
		CustomerRepository repository = (CustomerRepository) context.getBean("customerRepositoryImpl");
		repository.save(customer);
		System.out.println(repository.getCustomerByName("Kaya"));
	}

	private static void test_car_persistence(AnnotationConfigApplicationContext context) {
		Car car = new Car("Ford Kuga");
		CarRepository service = (CarRepository) context.getBean("carRepositoryImpl");
		service.save(car);
		System.out.println(service.getCustomerByModel("Ford Kuga"));

	}
}

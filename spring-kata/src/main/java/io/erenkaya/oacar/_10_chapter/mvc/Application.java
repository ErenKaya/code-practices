package io.erenkaya.oacar._10_chapter.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar._10_chapter.mvc.dao.CustomerRepository;
import io.erenkaya.oacar._10_chapter.mvc.service.RentalService;
import io.erenkaya.oacar.domain.entities.Car;
import io.erenkaya.oacar.domain.entities.Customer;
import io.erenkaya.oacar.domain.entities.Rental;

@ComponentScan
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) throws ParseException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//		test_car_persistence(context);
//		test_customer_persistence(context);
		Rental rental = test_rental_persistence(context);
		context.close();
	}

	private static Rental test_rental_persistence(AnnotationConfigApplicationContext context) throws ParseException {
		RentalService service = (RentalService) context.getBean("rentalServiceImpl");
		Date rentalBegin = new SimpleDateFormat("dd/MM/yy").parse("22/12/2013");
		Date rentalEnd = new SimpleDateFormat("dd/MM/yy").parse("23/12/2013");
		return service.rentACar(Application.getCustomer(), Application.getCar(), rentalBegin, rentalEnd);
	}

	@SuppressWarnings("unused")
	private static void test_customer_persistence(AnnotationConfigApplicationContext context) {
		Customer customer = getCustomer();
		CustomerRepository repository = (CustomerRepository) context.getBean("customerRepositoryImpl");
		repository.save(customer);
		System.out.println(repository.getCustomerByName("Kaya"));
	}

	private static Customer getCustomer() {
		return new Customer("Kaya", 22, "Eren");
	}
	
	private static Customer getCustomer2() {
		return new Customer("Kaya", 22, "Derya");
	}

	@SuppressWarnings("unused")
	private static void test_car_persistence(AnnotationConfigApplicationContext context) {
		Car car = getCar();
		CarRepository service = (CarRepository) context.getBean("carRepositoryImpl");
		service.save(car);
		System.out.println(service.getCustomerByModel("Ford Kuga"));

	}

	private static Car getCar() {
		return new Car("Ford Kuga");
	}
}

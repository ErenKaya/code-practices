package io.erenkaya.oacar._9_chapter.aop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.erenkaya.oacar.domain.Car;
import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalService;

@ComponentScan
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) throws ParseException {
		Application test = new Application();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		test.add_new_car(context);
	}

	private void add_new_car(ApplicationContext context) throws ParseException {
		Car car = new Car("Ford Kuga");
		RentalService service = (RentalService) context.getBean("rentalService");
		Date rentalBegin = new SimpleDateFormat("dd/MM/yy").parse("22/12/2013");
		Date rentalEnd = new SimpleDateFormat("dd/MM/yy").parse("23/12/2013");
		Customer customer = new Customer("Kaya", 22, "Eren", ThreadLocalRandom.current().nextLong());
		Rental rental = service.rentACar(customer, car, rentalBegin, rentalEnd);
		System.out.println("is rental rented? " + rental.isRented());
	}

}

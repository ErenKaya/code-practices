package io.erenkaya.oacar._8_chapter.anno_transaction.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities.Car;
import io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities.Customer;
import io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities.Rental;

public class RentalServiceTest {

	public static void main(String[] args) throws ParseException {
		RentalServiceTest test = new RentalServiceTest();
		String path = "oacar\\bean10.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
//		test.add_new_car();
		test.add_new_car(factory);
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
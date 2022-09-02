package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RentalServiceTest {

	public static void main(String[] args) throws ParseException {
		RentalServiceTest test = new RentalServiceTest();
		String path = "oacar\\bean5.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
//		test.add_new_car();
		test.add_new_car(factory);
	}

	private void add_new_car() throws ParseException {
		Car car = new Car("Ford Kuga");
		RentalService service = new RentalServiceImpl(new CustomerRepositoryImpl(), new RentalRepositoryImpl());
		Date rentalBegin = new SimpleDateFormat("dd/MM/yy").parse("22/12/2013");
		Date rentalEnd = new SimpleDateFormat("dd/MM/yy").parse("23/12/2013");
//		Customer customer = new Customer("Kaya", 22, "Eren", ThreadLocalRandom.current().nextLong());
		Rental rental = service.rentACar("Eren Kaya", car, rentalBegin, rentalEnd);
		System.out.println("is rental rented? " + rental.isRented());
	}

	private void add_new_car(ApplicationContext context) throws ParseException {
		Car car = new Car("Ford Kuga");
		RentalService service = (RentalService) context.getBean("rentalService");
		Date rentalBegin = new SimpleDateFormat("dd/MM/yy").parse("22/12/2013");
		Date rentalEnd = new SimpleDateFormat("dd/MM/yy").parse("23/12/2013");
		Rental rental = service.rentACar("Eren Kaya", car, rentalBegin, rentalEnd);
		System.out.println("is rental rented? " + rental.isRented());
	}

}

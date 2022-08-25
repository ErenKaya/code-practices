package io.erenkaya.oacar._3_chapter.proxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.erenkaya.oacar._3_chapter.proxy.example.Car;
import io.erenkaya.oacar._3_chapter.proxy.example.Rental;
import io.erenkaya.oacar._3_chapter.proxy.example.RentalService;

public class Application {
	public static void main(String[] args) throws ParseException {
		Application test = new Application();
		String path = "oacar\\bean2.xml";
		ApplicationContext factory = new ClassPathXmlApplicationContext(path);
//		test.add_new_car();
		test.add_new_car(factory);
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

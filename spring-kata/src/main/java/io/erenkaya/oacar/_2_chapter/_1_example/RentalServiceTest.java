package io.erenkaya.oacar._2_chapter._1_example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalServiceTest {

	public static void main(String[] args) throws ParseException {
		RentalServiceTest test = new RentalServiceTest();
		test.add_new_car();
	}

	private void add_new_car() throws ParseException {
		Car car = new Car("Ford Kuga");
		RentalService service = new RentalService();
		Date rentalBegin = new SimpleDateFormat("dd/MM/yy").parse("22/12/2013");
		Date rentalEnd = new SimpleDateFormat("dd/MM/yy").parse("23/12/2013");
		Rental rental = service.rentACar("Eren Kaya", car, rentalBegin, rentalEnd);
		System.out.println("is rental rented? " + rental.isRented());
	}

}

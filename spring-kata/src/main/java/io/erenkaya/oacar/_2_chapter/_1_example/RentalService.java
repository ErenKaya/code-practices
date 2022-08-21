package io.erenkaya.oacar._2_chapter._1_example;

import java.util.Date;

public class RentalService {

	public Rental rentACar(String name, Car car, Date rentDateBegin, Date rentDateEnd) {
		CustomerRepository customerRepository = new CustomerRepository();
		Customer customer = customerRepository.getCustomerByName(name);

		if (customer == null) {
			customer = new Customer(name);
			customerRepository.save(customer);
		}
		Rental rental = new Rental();
		rental.setCar(car);
		rental.setCustomer(customer);
		RentalRepository rentalRepository = new RentalRepository();
		rentalRepository.save(rental);
		return rental;
	}

}

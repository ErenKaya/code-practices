package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import java.util.Date;

public class RentalServiceImpl implements RentalService {
	private CustomerRepository customerRepository;
	private RentalRepository rentalRepository;

	public RentalServiceImpl() {
		super();
	}

	public RentalServiceImpl(CustomerRepository customerRepository,
			 RentalRepository rentalRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
	}

	@Override
	public Rental rentACar(String name, Car car, Date rentDateBegin, Date rentDateEnd) {
		Customer customer = customerRepository.getCustomerByName(name);

		if (customer == null) {
			customer = new Customer(name);
			customerRepository.save(customer);
		}
		Rental rental = new Rental();
		rental.setCar(car);
		rental.setCustomer(customer);
		rentalRepository.save(rental);
		return rental;
	}

}

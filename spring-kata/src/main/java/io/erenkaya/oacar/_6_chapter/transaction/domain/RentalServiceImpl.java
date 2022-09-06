package io.erenkaya.oacar._6_chapter.transaction.domain;

import java.util.Date;

import io.erenkaya.oacar.domain.Car;
import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.CustomerRepository;
import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;
import io.erenkaya.oacar.domain.RentalService;

public class RentalServiceImpl implements RentalService {
	private CustomerRepository customerRepository;
	private RentalRepository rentalRepository;

	public RentalServiceImpl() {
		super();
	}

	public RentalServiceImpl(CustomerRepository customerRepository, RentalRepository rentalRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
	}

	@Override
	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd) {
		Customer dbCustomer = customerRepository.getCustomerByName(customer.getName());

		if (dbCustomer == null) {
			customerRepository.save(customer);
		}
		Rental rental = new Rental();
		rental.setCar(car);
		rental.setCustomer(customer);
		rentalRepository.save(rental);
		return rental;
	}

}

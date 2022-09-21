package io.erenkaya.oacar._9_chapter.dynamic_class.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import io.erenkaya.oacar.domain.Car;
import io.erenkaya.oacar.domain.CarRepository;
import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.CustomerRepository;
import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;
import io.erenkaya.oacar.domain.RentalService;

public class RentalServiceImpl implements RentalService {

	private CustomerRepository customerRepository;
	private RentalRepository rentalRepository;
	private CarRepository carRepository;

	@Autowired
	public RentalServiceImpl(CustomerRepository customerRepository, RentalRepository rentalRepository,
			CarRepository carRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
		this.carRepository = carRepository;
	}

	@Override
	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd) {
		Customer dbCustomer = customerRepository.getCustomerByName(customer.getName());
		Car dbCar = carRepository.getCustomerByModel(car.getModel());

		if (dbCustomer == null) {
			customerRepository.save(customer);
		}
		if (dbCar == null) {
			carRepository.save(car);
		}
		Rental rental = new Rental();
		rental.setCar(car);
		rental.setCustomer(customer);
		rentalRepository.save(rental);
		return rental;
	}

}

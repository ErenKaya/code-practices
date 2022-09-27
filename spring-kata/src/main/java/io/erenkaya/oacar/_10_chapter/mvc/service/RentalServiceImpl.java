package io.erenkaya.oacar._10_chapter.mvc.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar._10_chapter.mvc.dao.CustomerRepository;
import io.erenkaya.oacar._10_chapter.mvc.dao.RentalRepository;
import io.erenkaya.oacar.domain.entities.Car;
import io.erenkaya.oacar.domain.entities.Customer;
import io.erenkaya.oacar.domain.entities.Rental;

public class RentalServiceImpl implements RentalService {

	private CustomerRepository customerRepository;

	private RentalRepository rentalRepository;

	private CarRepository carRepository;

	public RentalServiceImpl() {
		super();
	}

	public RentalServiceImpl(CustomerRepository customerRepository, RentalRepository rentalRepository,
			CarRepository carRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
		this.carRepository = carRepository;
	}

	@Override
	@Transactional
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

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void setRentalRepository(RentalRepository rentalRepository) {
		this.rentalRepository = rentalRepository;
	}

}

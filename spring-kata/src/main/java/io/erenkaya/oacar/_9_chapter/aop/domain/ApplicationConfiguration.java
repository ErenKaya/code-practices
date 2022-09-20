package io.erenkaya.oacar._9_chapter.aop.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.erenkaya.oacar.domain.CarRepository;
import io.erenkaya.oacar.domain.CustomerRepository;
import io.erenkaya.oacar.domain.RentalRepository;
import io.erenkaya.oacar.domain.RentalService;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public CarRepository carRepository() {
		return new CarRepositoryImpl();
	}

	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepositoryImpl();
	}

	@Bean
	public RentalRepository rentalRepository() {
		return new RentalRepositoryImpl();
	}

	@Bean
	RentalService rentalService() {
		return new RentalServiceImpl(this.customerRepository(), this.rentalRepository(), this.carRepository());
	}
}

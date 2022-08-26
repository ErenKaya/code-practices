package io.erenkaya.oacar._3_chapter.proxy.example;

import java.lang.reflect.Proxy;
import java.util.Date;

import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import io.erenkaya.oacar._3_chapter.proxy.example.log.LogHandler;

public class RentalServiceImpl implements RentalService, BeanPostProcessor {
	private CustomerRepository customerRepository;
	private RentalRepository rentalRepository;

	public RentalServiceImpl() {
		super();
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

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postBefore");
		if (bean instanceof RentalService) {
			Class[] interfaces = new Class[] { RentalService.class };
			LogHandler logHandler = new LogHandler((RentalService) bean);
			ClassLoader loader = bean.getClass().getClassLoader();
			RentalService serviceProxy = (RentalService) Proxy.newProxyInstance(loader, interfaces, logHandler);
			return serviceProxy;
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public void setRentalRepository(RentalRepository rentalRepository) {
		this.rentalRepository = rentalRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("destroy method called");
	}

}

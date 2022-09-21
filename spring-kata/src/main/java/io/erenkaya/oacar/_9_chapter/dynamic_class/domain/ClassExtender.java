package io.erenkaya.oacar._9_chapter.dynamic_class.domain;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import io.erenkaya.oacar.domain.Bus;
import io.erenkaya.oacar.domain.BusService;
import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.Rental;

@Aspect
public class ClassExtender implements BusService {

	@DeclareParents(value = "io.erenkaya.oacar._9_chapter.dynamic_class.domain.RentalServiceImpl", defaultImpl = ClassExtender.class)
	private static BusService mixin;

	@Override
	public Rental rentABus(Customer customer, Bus car, Date rentDateBegin, Date rentDateEnd) {
		System.out.println("Bus Rented!");
		return new Rental();
	}

}

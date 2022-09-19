package io.erenkaya.oacar._9_chapter.aop.domain;

import java.util.Date;

import io.erenkaya.oacar._9_chapter.aop.domain.entities.Car;
import io.erenkaya.oacar._9_chapter.aop.domain.entities.Customer;
import io.erenkaya.oacar._9_chapter.aop.domain.entities.Rental;


public interface RentalService {

	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd);

}

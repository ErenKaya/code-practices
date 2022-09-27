package io.erenkaya.oacar._8_chapter.anno_transaction.domain;

import java.util.Date;

import io.erenkaya.oacar.domain.entities.Car;
import io.erenkaya.oacar.domain.entities.Customer;
import io.erenkaya.oacar.domain.entities.Rental;

public interface RentalService {

	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd);

}

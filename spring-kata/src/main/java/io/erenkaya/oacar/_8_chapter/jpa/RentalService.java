package io.erenkaya.oacar._8_chapter.jpa;

import java.util.Date;

import io.erenkaya.oacar._8_chapter.jpa.entities.Car;
import io.erenkaya.oacar._8_chapter.jpa.entities.Customer;
import io.erenkaya.oacar._8_chapter.jpa.entities.Rental;



public interface RentalService {

	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd);

}

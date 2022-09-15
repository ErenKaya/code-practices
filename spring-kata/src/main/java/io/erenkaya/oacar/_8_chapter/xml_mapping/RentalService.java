package io.erenkaya.oacar._8_chapter.xml_mapping;

import java.util.Date;

import io.erenkaya.oacar._8_chapter.entities.Car;
import io.erenkaya.oacar._8_chapter.entities.Customer;
import io.erenkaya.oacar._8_chapter.entities.Rental;


public interface RentalService {

	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd);

}

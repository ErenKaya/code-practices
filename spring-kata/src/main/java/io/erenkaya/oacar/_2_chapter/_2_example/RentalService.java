package io.erenkaya.oacar._2_chapter._2_example;

import java.util.Date;

public interface RentalService {

	public Rental rentACar(String name, Car car, Date rentDateBegin, Date rentDateEnd);

}

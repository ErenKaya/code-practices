package io.erenkaya.oacar._3_chapter.proxy.example;

import java.util.Date;

public interface RentalService {

	public Rental rentACar(String name, Car car, Date rentDateBegin, Date rentDateEnd);

}

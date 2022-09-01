package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import java.util.Date;

public interface RentalService {

	public Rental rentACar(String name, Car car, Date rentDateBegin, Date rentDateEnd);

}

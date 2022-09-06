package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;

public class RentalRepositoryImpl implements RentalRepository {

	public void save(Rental rental) {
		rental.setRented(true);
	}

}

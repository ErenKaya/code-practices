package io.erenkaya.oacar._5_chapter.jdbctemplate.domain;

public class RentalRepositoryImpl implements RentalRepository {

	public void save(Rental rental) {
		rental.setRented(true);
	}

}

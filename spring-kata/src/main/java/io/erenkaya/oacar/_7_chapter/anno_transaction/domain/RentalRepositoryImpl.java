package io.erenkaya.oacar._7_chapter.anno_transaction.domain;

import javax.inject.Named;

import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;

@Named
public class RentalRepositoryImpl implements RentalRepository {

	public void save(Rental rental) {
		rental.setRented(true);
	}

}

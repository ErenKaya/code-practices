package io.erenkaya.oacar._9_chapter.aop.domain;

import java.util.ArrayList;
import java.util.List;

import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;

public class RentalRepositoryImpl implements RentalRepository {
	private List<Rental> rentalList = new ArrayList<Rental>();

	@Override
	public void save(Rental rental) {
		rental.setRented(this.rentalList.add(rental));
	}

}

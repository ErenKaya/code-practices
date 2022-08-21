package io.erenkaya.oacar._2_chapter._2_example;

public class RentalRepositoryImpl implements RentalRepository {

	public void save(Rental rental) {
		rental.setRented(true);
	}

}

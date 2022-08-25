package io.erenkaya.oacar._3_chapter.proxy.example;

public class RentalRepositoryImpl implements RentalRepository {

	public void save(Rental rental) {
		rental.setRented(true);
	}

}

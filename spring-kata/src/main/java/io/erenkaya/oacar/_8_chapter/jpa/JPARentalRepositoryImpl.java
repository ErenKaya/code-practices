package io.erenkaya.oacar._8_chapter.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.erenkaya.oacar._8_chapter.jpa.entities.Rental;


public class JPARentalRepositoryImpl implements RentalRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public JPARentalRepositoryImpl() {
		super();

	}

	public void save(Rental rental) {
		rental.setIsRented(true);
		this.entityManager.persist(rental);
	}

}

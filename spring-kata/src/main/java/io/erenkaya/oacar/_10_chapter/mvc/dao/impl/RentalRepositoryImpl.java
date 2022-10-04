package io.erenkaya.oacar._10_chapter.mvc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.erenkaya.oacar._10_chapter.mvc.dao.RentalRepository;
import io.erenkaya.oacar.domain.entities.Rental;

@Repository
public class RentalRepositoryImpl implements RentalRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Rental rental) {
		rental.setIsRented(true);
		entityManager.persist(rental);
	}

}

package io.erenkaya.oacar._10_chapter.mvc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar.domain.entities.Car;

@Repository
@Transactional
public class CarRepositoryImpl implements CarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Car getCustomerByModel(String name) {
		Car result = null;
		try {
			result = (Car) entityManager.createQuery("from Car c where c.model=:name").setParameter("name", name)
					.getSingleResult();
		} catch (NoResultException e) {
			// record bulunamadigi için null geri veriyoruz.
		}
		return result;

	}

	@Override
	public void save(Car car) {
		entityManager.persist(car);
	}

}

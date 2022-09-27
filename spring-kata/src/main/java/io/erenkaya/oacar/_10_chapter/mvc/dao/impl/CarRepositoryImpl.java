package io.erenkaya.oacar._10_chapter.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.erenkaya.oacar._10_chapter.mvc.dao.CarRepository;
import io.erenkaya.oacar.domain.entities.Car;

@Repository
public class CarRepositoryImpl implements CarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Car getCustomerByModel(String name) {
		Car result = null, result2 = null;
		try {
			result = (Car) entityManager.createQuery("from Car c where c.model=:name").setParameter("name", name)
					.getSingleResult();
			result2 = (Car) entityManager.createQuery("from Car where 1=1").getSingleResult();
		} catch (NoResultException e) {
			// record bulunamadigi için null geri veriyoruz.
		}
		return result;

	}

	@Override
	@Transactional
	public void save(Car car) {
		entityManager.persist(car);
	}

}

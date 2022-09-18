package io.erenkaya.oacar._8_chapter.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import io.erenkaya.oacar._8_chapter.jpa.entities.Car;


public class JPACarRepositoryImpl implements CarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Car getCustomerByModel(String name) {
		String sql = "from Car c where c.model=:name";
		Car car = null;
		try {
			car = (Car) entityManager.createQuery(sql).setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
		}
		return car;
	}

	@Override
	public void save(Car car) {
		entityManager.persist(car);
	}

}

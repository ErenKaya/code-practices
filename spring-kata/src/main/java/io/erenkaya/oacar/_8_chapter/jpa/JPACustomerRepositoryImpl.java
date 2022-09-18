package io.erenkaya.oacar._8_chapter.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import io.erenkaya.oacar._8_chapter.jpa.entities.Customer;



public class JPACustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public JPACustomerRepositoryImpl() {

	}

	@Override
	public Customer getCustomerByName(String name) {

		String sql = "from Customer c where c.name=:name";
		Customer customer = null;
		try {
			customer = (Customer) entityManager.createQuery(sql).setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
		}

		return customer;
	}

	@Override
	public void save(Customer customer) {
		entityManager.persist(customer);
	}
}

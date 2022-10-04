package io.erenkaya.oacar._10_chapter.mvc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.erenkaya.oacar._10_chapter.mvc.dao.CustomerRepository;
import io.erenkaya.oacar.domain.entities.Customer;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer getCustomerByName(String name) {
		Customer result = null;
		try {
			result = (Customer) entityManager.createQuery("from Customer c where c.name=:name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			// record bulunamadigi için null geri veriyoruz.
		}
		return result;
	}

	@Override
	public void save(Customer customer) {
		entityManager.persist(customer);
	}

}

package io.erenkaya.oacar._9_chapter.aop.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import io.erenkaya.oacar._9_chapter.aop.domain.entities.Rental;


public class HibernateRentalRepositoryImpl implements RentalRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateRentalRepositoryImpl() {
		super();

	}

	public void save(Rental rental) {
		this.getCurrentSession().save(rental);
		rental.setRented(true);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}

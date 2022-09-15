package io.erenkaya.oacar._8_chapter.xml_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import io.erenkaya.oacar._8_chapter.entities.Rental;

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
		rental.setIsRented(true);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}

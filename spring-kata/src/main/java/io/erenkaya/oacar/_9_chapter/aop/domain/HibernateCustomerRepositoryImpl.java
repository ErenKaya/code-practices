package io.erenkaya.oacar._9_chapter.aop.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import io.erenkaya.oacar._9_chapter.aop.domain.entities.Customer;


public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateCustomerRepositoryImpl() {

	}

	@Override
	public Customer getCustomerByName(String name) {
		String sql = "from Customer c where c.name=:name";
		Query<Customer> query = getCurrentSession().createQuery(sql);
		query.setString("name", name);
		return query.uniqueResult();
	}

	@Override
	public void save(Customer customer) {
		this.getCurrentSession().save(customer);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}

package io.erenkaya.oacar._8_chapter.anno_transaction.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities.Car;

public class HibernateCarRepositoryImpl implements CarRepository {

	private SessionFactory sessionFactory;

	public HibernateCarRepositoryImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Car getCustomerByModel(String name) {
		String sql = "from Car c where c.model=:name";
		Query<Car> query = getCurrentSession().createQuery(sql);
		query.setString("name", name);
		return query.uniqueResult();
	}

	@Override
	public void save(Car car) {
		getCurrentSession().save(car);
	}

}

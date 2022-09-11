package io.erenkaya.oacar._7_chapter.anno_transaction.domain;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import io.erenkaya.oacar.domain.Car;
import io.erenkaya.oacar.domain.Customer;
import io.erenkaya.oacar.domain.CustomerRepository;
import io.erenkaya.oacar.domain.Rental;
import io.erenkaya.oacar.domain.RentalRepository;
import io.erenkaya.oacar.domain.RentalService;

@Named("rentalService")
public class RentalServiceImpl extends JdbcDaoSupport implements RentalService {

	@Inject
	private CustomerRepository customerRepository;

	@Inject
	private RentalRepository rentalRepository;

	@Inject
	private TransactionTemplate txTemplate;

	@Inject
	public void injectDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public RentalServiceImpl() {
		super();
	}

	public RentalServiceImpl(CustomerRepository customerRepository, RentalRepository rentalRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
	}

	@Transactional
	@Override
	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd) {
		return txTemplate.execute(new TransactionCallback<Rental>() {
			@Override
			public Rental doInTransaction(TransactionStatus status) {
				Customer dbCustomer = customerRepository.getCustomerByName(customer.getName());

				if (dbCustomer == null) {
					customerRepository.save(customer);
				}
				Rental rental = new Rental();
				rental.setCar(car);
				rental.setCustomer(customer);
				rentalRepository.save(rental);
				return rental;
			}
		});

	}

}

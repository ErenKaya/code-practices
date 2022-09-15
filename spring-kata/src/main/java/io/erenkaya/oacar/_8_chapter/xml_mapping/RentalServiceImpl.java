package io.erenkaya.oacar._8_chapter.xml_mapping;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import io.erenkaya.oacar._8_chapter.entities.Car;
import io.erenkaya.oacar._8_chapter.entities.Customer;
import io.erenkaya.oacar._8_chapter.entities.Rental;

public class RentalServiceImpl implements RentalService {

	private CustomerRepository customerRepository;

	private RentalRepository rentalRepository;

	private CarRepository carRepository;

	private HibernateTemplate hibernateTemplate;

	public RentalServiceImpl() {
		super();
	}

	public RentalServiceImpl(CustomerRepository customerRepository, RentalRepository rentalRepository,
			CarRepository carRepository) {
		super();
		this.customerRepository = customerRepository;
		this.rentalRepository = rentalRepository;
		this.carRepository = carRepository;
	}

	@Override
	@Transactional
	public Rental rentACar(Customer customer, Car car, Date rentDateBegin, Date rentDateEnd) {
		return hibernateTemplate.execute(new HibernateCallback<Rental>() {
			@Override
			public Rental doInHibernate(Session session) throws HibernateException {
				Customer dbCustomer = customerRepository.getCustomerByName(customer.getName());
				Car dbCar = carRepository.getCustomerByModel(car.getModel());

				if (dbCustomer == null) {
					customerRepository.save(customer);
				}
				if (dbCar == null) {
					carRepository.save(car);
				}
				Rental rental = new Rental();
				rental.setCar(car);
				rental.setCustomer(customer);
				rentalRepository.save(rental);
				return rental;
			}
		});

	}

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void setRentalRepository(RentalRepository rentalRepository) {
		this.rentalRepository = rentalRepository;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}

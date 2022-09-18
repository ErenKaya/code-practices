package io.erenkaya.oacar._8_chapter.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {

	@OneToOne
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	private Car car;

	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@Column(name = "isRented")
	private boolean isRented;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

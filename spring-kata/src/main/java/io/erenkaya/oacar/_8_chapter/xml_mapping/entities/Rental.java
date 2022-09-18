package io.erenkaya.oacar._8_chapter.xml_mapping.entities;

public class Rental {

	private Car car;

	private Customer customer;

	private boolean isRented;
	private long id;

	public Rental() {
		super();
	}

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

	public boolean getIsRented() {
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

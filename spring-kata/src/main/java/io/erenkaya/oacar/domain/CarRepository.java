package io.erenkaya.oacar.domain;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}

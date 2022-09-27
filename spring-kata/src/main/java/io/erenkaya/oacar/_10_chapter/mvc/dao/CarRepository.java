package io.erenkaya.oacar._10_chapter.mvc.dao;

import io.erenkaya.oacar.domain.entities.Car;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}

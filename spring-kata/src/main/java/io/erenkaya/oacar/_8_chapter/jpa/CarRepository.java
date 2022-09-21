package io.erenkaya.oacar._8_chapter.jpa;

import io.erenkaya.oacar._8_chapter.jpa.entities.Car;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}
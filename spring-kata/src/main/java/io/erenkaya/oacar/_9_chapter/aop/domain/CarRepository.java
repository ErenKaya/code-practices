package io.erenkaya.oacar._9_chapter.aop.domain;

import io.erenkaya.oacar._9_chapter.aop.domain.entities.Car;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}

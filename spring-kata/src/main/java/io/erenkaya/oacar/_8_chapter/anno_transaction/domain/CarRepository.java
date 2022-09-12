package io.erenkaya.oacar._8_chapter.anno_transaction.domain;

import io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities.Car;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}

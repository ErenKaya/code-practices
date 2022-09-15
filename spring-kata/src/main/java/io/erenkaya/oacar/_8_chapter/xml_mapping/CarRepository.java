package io.erenkaya.oacar._8_chapter.xml_mapping;

import io.erenkaya.oacar._8_chapter.entities.Car;

public interface CarRepository {

	public Car getCustomerByModel(String name);

	public void save(Car car);

}

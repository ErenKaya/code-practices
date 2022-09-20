package io.erenkaya.oacar._9_chapter.aop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.erenkaya.oacar.domain.Car;
import io.erenkaya.oacar.domain.CarRepository;

public class CarRepositoryImpl implements CarRepository {

	private List<Car> carList = new ArrayList<Car>();

	public CarRepositoryImpl() {
		super();
		carList.add(new Car("Kuga", "Ford"));
		carList.add(new Car("Egea", "Fiat"));
	}

	@Override
	public Car getCustomerByModel(String name) {
		Optional<Car> car = carList.stream().filter(c -> c.getModel().equals(name)).findFirst();
		if (car.isPresent()) {
			return car.get();
		} else {
			return null;
		}
	}

	@Override
	public void save(Car car) {
		carList.add(car);
	}

}

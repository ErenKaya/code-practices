package io.erenkaya.oacar._4_chapter.provider;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

@Named("carFactory")
@Singleton
public class CarFactoryImpl implements CarFactory {

	private Set<Car> cars;
	public static final int MAX_CAR_COUNT = 3;

	@Inject
	public CarFactoryImpl(Provider<Car> cars) {
		this.cars = new HashSet<Car>();
		for (int i = 0; i < MAX_CAR_COUNT; i++) {
			this.cars.add(cars.get());
		}
	}

	@Override
	public Car build() {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car c : cars) {
			sb.append(c);
		}
		return sb.toString();
	}

}

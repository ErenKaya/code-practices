package io.erenkaya.oacar._4_chapter.imp;

import javax.inject.Provider;

import org.springframework.context.annotation.Bean;

public class AppConfig {
	@Bean
	public Car car() {
		return new Car();
	}

	@Bean
	public CarFactory carFactory(Provider<Car> cars) {
		return new CarFactoryImpl(cars);
	}
}

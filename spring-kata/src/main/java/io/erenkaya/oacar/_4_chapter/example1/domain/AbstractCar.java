package io.erenkaya.oacar._4_chapter.example1.domain;

public abstract class AbstractCar {

	private CarType carType;

	public AbstractCar() {
		super();
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

}

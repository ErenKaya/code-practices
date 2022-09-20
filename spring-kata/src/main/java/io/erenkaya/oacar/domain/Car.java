package io.erenkaya.oacar.domain;

public class Car {

	private String model;
	private String brand;

	public Car(String model) {
		super();
		this.model = model;
	}

	public Car(String model, String brand) {
		super();
		this.model = model;
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

}

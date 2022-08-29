package io.erenkaya.oacar._4_chapter.example1.domain;

import com.google.common.base.MoreObjects;

public class Car extends AbstractCar {
	private String brand;
	private String model;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return String.format("Car={brand=%s ,model = %s ,type= %s }", this.brand, this.model, this.getCarType());
	}

}

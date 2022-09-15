package io.erenkaya.oacar._8_chapter.entities;

public class Car {
	private long id;

	private String model;

	public Car() {
		super();
	}

	public Car(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

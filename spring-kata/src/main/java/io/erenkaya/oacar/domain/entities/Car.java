package io.erenkaya.oacar.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "car")
@Entity
public class Car {
	@GeneratedValue
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "model")
	private String model;

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

	public Car() {
		super();
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return String.format("Car=[%s, %d]", this.getModel(), this.getId());
	}

}

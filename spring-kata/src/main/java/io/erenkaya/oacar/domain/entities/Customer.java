package io.erenkaya.oacar.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "firstname")
	private String firstname;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	public Customer(String name, int age, String firstname, long id) {
		this(name, age, firstname);
		this.id = id;
	}

	public Customer(String name, int age, String firstname) {
		super();
		this.name = name;
		this.age = age;
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getFirstname() {
		return firstname;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Customer=[%s, %s, %d, %d]", this.getName(), this.getFirstname(), this.getAge(),
				this.getId());
	}

	public Customer() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
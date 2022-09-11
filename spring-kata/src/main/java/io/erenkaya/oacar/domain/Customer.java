package io.erenkaya.oacar.domain;

public class Customer {

	private String name;
	private int age;
	private String firstname;
	private long id;

	public Customer(String name, int age, String firstname, long id) {
		super();
		this.name = name;
		this.age = age;
		this.firstname = firstname;
		this.id = id;
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

}

package io.erenkaya.oacar._8_chapter.anno_transaction.domain.entities;

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

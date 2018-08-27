package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.entity;

import java.util.List;

public class Person {
	enum Gender {
		MALE, FAMALE
	}

	private String name;
	private String surname;
	private int age;
	private Gender gender;
	private boolean isVendor;
	private List<Item> buying;
	private List<Item> selling;

	public Person(String name, String surname, int age, Gender gender, boolean isVendor, List<Item> buying,
			List<Item> selling) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.isVendor = isVendor;
		this.buying = buying;
		this.selling = selling;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isVendor() {
		return isVendor;
	}

	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	public List<Item> getBuying() {
		return buying;
	}

	public void setBuying(List<Item> buying) {
		this.buying = buying;
	}

	public List<Item> getSelling() {
		return selling;
	}

	public void setSelling(List<Item> selling) {
		this.selling = selling;
	}

}

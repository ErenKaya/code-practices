package kim.eren.code_practices.compositedp;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String surname;
	private double salary;
	private List<Employee> subordinates;

	public Employee(String name, String surname, double salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee e) {
		subordinates.add(e);
	}
	
	public void removeEmployee(Employee e) {
		subordinates.remove(e);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	 

}

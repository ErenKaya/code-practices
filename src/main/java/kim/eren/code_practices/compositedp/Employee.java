package kim.eren.code_practices.compositedp;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String surname;
	private String department;
	private double salary;
	private List<Employee> subordinates;

	public Employee(String name, String surname, String department, double salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.department = department;
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


	public List<Employee> getSubordinates() {
		return subordinates;
	}



	public String getDepartment() {
		return department;
	}


}

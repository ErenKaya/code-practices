package kim.eren.code_practices.tpoint.compositedp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.compositedp.Employee;

public class CompositeDesignPatternTest {
	/**
	 * This pattern used for hierarchical structures E.g.: TreeView, JavaUI
	 * components This examples for a company which has Ceo, department of sales,
	 * department of finance
	 */

	Employee ceo, headOfSales, headOfFinance, clerk1, clerk2, salesExecutive1, salesExecutive2;

	@Before
	public void init() {
		ceo = new Employee("Ibrahim", "Pardon", "Ceo", 50000);
		headOfSales = new Employee("Aydın", "Diktepe", "Head Of Sales", 35000);
		headOfFinance = new Employee("Muzaffer", "Yantepe", "Head Of Finance", 35000);
		ceo.addEmployee(headOfSales);
		ceo.addEmployee(headOfFinance);

		clerk1 = new Employee("Laura", "Arouka", "Finances", 10000);
		clerk2 = new Employee("Bob", "Bob", "Finances", 10000);
		headOfFinance.addEmployee(clerk1);
		headOfFinance.addEmployee(clerk2);

		salesExecutive1 = new Employee("Richard", "Drarh", "Sales", 10000);
		salesExecutive2 = new Employee("Rob", "Bor", "Sales", 10000);
		headOfSales.addEmployee(salesExecutive1);
		headOfSales.addEmployee(salesExecutive2);
	}

	@Test
	public void test_ceo_own_employees() {
		assertEquals("Muzaffer", findEmployeeByName("Muzaffer", ceo).getName());
		assertEquals("Aydın", findEmployeeByName("Aydın", ceo).getName());
	}

	@Test
	public void test_sale_personals() {
		for (Employee salesPersonal : findEmployeeByDepartment("Sales", headOfSales)) {
			assertEquals("Sales", salesPersonal.getDepartment());
		}

	}
	
	@Test
	public void test_finance_personals() {
		for (Employee financePersonal : findEmployeeByDepartment("Finances", headOfFinance)) {
			assertEquals("Finances", financePersonal.getDepartment());
		}

	}
	
	private Employee findEmployeeByName(String name, Employee e) {

		for (Employee employee : e.getSubordinates()) {
			if (employee.getName().equalsIgnoreCase(name)) {
				return employee;
			} else {
				continue;
			}
		}
		return null;
	}

	private List<Employee> findEmployeeByDepartment(String department, Employee e) {
		int counter = 0;
		for (Employee employee : e.getSubordinates()) {
			if (employee.getDepartment().equalsIgnoreCase(department)) {
				counter++;
			} else {
				continue;
			}
		}
		return e.getSubordinates().size() == counter ? e.getSubordinates() : null;
	}

}

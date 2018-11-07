package kim.eren.code_practices.eor_oop_book.behavioral.iterator.first_example;

import org.junit.Before;

public class TestCPIterator {

	CPAbstractList<CPEmployee> employeeList;
	CPIterator<CPEmployee> employeeIterator;

	@Before
	public void init() {
		employeeIterator = employeeList.createIterator();
	}

}

package kim.eren.code_practices.eor_oop_book.behavioral.iterator.first_example;

import org.junit.Before;

public class TestCPIterator {

	CPAbstractList<CPEmployee> employeeList;
	CPIterator<CPEmployee> employeeIterator;

	static String method() {
		return "a";
	}

	static {
		System.out.println(method());

	}

	TestCPIterator() {
		System.out.println("v");
	}

	public static void main(String[] args) {
		TestCPIterator t = new TestCPIterator();
	}

	@Before
	public void init() {
		employeeIterator = employeeList.createIterator();
	}

}

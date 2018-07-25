package kim.eren.oca_8_certificate.lambda.tutorialspoint.functional;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FunctionalInterfaceTest {

	FunctionalInterface fInterface;
	private List resultList;

	@Before
	public void init() {
		fInterface = new FunctionalInterface();
		fInterface.list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void test_predicate_all_numbers_from_list() {
		resultList = fInterface.eval(fInterface.list, n -> true);
		assertEquals(fInterface.list.size(), resultList.size());
		System.out.println(resultList.toString());
	}

	@Test
	public void test_predicate_even_number_from_list() {
		resultList = fInterface.eval(fInterface.list, n -> n % 2 == 0);
		assertEquals(4, resultList.size());
		System.out.println(resultList.toString());
	}

	@Test
	public void test_pridicate_odd_number_from_list() {
		resultList = fInterface.eval(fInterface.list, n -> n % 2 == 1);
		assertEquals(5, resultList.size());
		System.out.println(resultList.toString());
	}

}

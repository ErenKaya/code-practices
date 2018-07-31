package kim.eren.oca_8_certificate.lambda.tutorialspoint.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class StreamFunctionTest {
	StreamFunction streamFunc;

	@Before
	public void init() {
		streamFunc = new StreamFunction();
	}

	@Test
	public void filter_empty_string_method_test_from_lambda_expressions() {
		int count = streamFunc.filterEmptyString(generateDummyStringList());
		assertEquals(2, count);
	}

	@Test
	public void map_method_test_from_lambda_expressions() {
		List<Integer> intList = generateRandomIntegerList(1);
		assertEquals((Integer) (intList.get(0) * intList.get(0)), (Integer) streamFunc.getSquareList(intList).get(0));

	}

	// @Test
	public void test_generated_int_list_items() {
		generateRandomIntegerList(10).forEach(System.out::println);
	}

	// @Test
	public void test_generated_string_list_items() {
		generateDummyStringList().forEach(System.out::println);
	}

	public List<Integer> generateRandomIntegerList(Integer limit) {
		return new Random().ints().limit(limit).mapToObj(i -> i).collect(Collectors.toList());
	}

	public List<String> generateDummyStringList() {
		List<String> strList = Arrays.asList("Fsad", "q", "", "asfa", "123", "Java", "", "oki", "jakarta", "ee", "eg");

		return strList;
	}

}

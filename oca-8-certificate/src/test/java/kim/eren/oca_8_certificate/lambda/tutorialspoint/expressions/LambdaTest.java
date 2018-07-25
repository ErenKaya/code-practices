package kim.eren.oca_8_certificate.lambda.tutorialspoint.expressions;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.oca_8_certificate.lambda.tutorialspoint.expressions.Java8;
import kim.eren.oca_8_certificate.lambda.tutorialspoint.expressions.MathOperation;

public class LambdaTest {

	Java8 javaTest;

	@Before
	public void init() {
		javaTest = new Java8();
	}

	@Test
	public void test_substraction_with_lambda() {
		MathOperation substractionOperate = (a, b) -> a - b;
		int result = javaTest.operate(10, 6, substractionOperate);
		assertEquals(4, result);
	}

	@Test
	public void test_addition_with_lambda() {
		MathOperation additionOperate = (int a, int b) -> a + b;
		int result = javaTest.operate(10, 6, additionOperate);
		assertEquals(16, result);
	}
	
	@Test
	public void test_multiplication_with_lambda() {
		MathOperation multiplicationOperate = (int a, int b) -> {return a * b;};
		int result = javaTest.operate(10, 6, multiplicationOperate);
		assertEquals(60, result);
	}
	
	@Test
	public void test_division_with_lambda() {
		MathOperation divisionOperate = (a,b) -> {return a / b;};
		int result = javaTest.operate(20, 5, divisionOperate);
		assertEquals(4, result);
	}

}

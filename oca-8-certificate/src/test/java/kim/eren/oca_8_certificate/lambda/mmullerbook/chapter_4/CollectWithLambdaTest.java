package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.InvokeMethod;

import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person;
import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person.Gender;
import kim.eren.oca_8_certificate.lambda.mmullerbook.util.PersonUtil;

public class CollectWithLambdaTest {

	List<Person> personList;

	@Before
	public void init() {
		personList = PersonUtil.createDummyPersonListOnlyAge();
	}

	@Test
	public void test_basic_lambda_expressions() {
		assertEquals(2,
				PersonUtil.getPersonByCondition(personList, person -> person.getGender() == Gender.FAMALE).size());
	}

	@Test
	/**
	 * that notation very clearly understandable because you want to see what is
	 * that instance's object.
	 */
	public void test_diffrent_notation_lambda() {
		assertEquals(2,
				PersonUtil.getPersonByCondition(personList, (Person p) -> p.getGender() == Gender.FAMALE).size());
	}
	@Test
	public void test_method_carrier() {
		assertNotNull(Chapter4InvokeMethod.invokeMethod(() -> PersonUtil.getVendorCount(personList)));
	}

}

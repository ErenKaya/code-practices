package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.abstracts.Condition;
import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.executors.YoungerThanCondition;
import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person;
import kim.eren.oca_8_certificate.lambda.mmullerbook.util.PersonUtil;

public class BehaviorParameterizationTest {
	List<Person> personList;

	@Before
	public void init() {
		personList = PersonUtil.createDummyPersonListOnlyAge();
	}

	@Test
	public void test_person_younger_than_specific_age() {
		assertEquals(2, PersonUtil.getPersonByCondition(personList, new YoungerThanCondition(20)).size());
	}

	@Test
	public void test_person_younger_than_specific_age_with_anonymousclass() {
		assertEquals(2, PersonUtil.getPersonByCondition(personList, new Condition<Person>() {
			@Override
			public boolean test(Person t) {
				return t.getAge() < 20;
			}
		}).size());
	}

}

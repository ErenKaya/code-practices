package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.abstracts.Condition;
import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.entity.Person;
import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.executors.YoungerThanCondition;

public class BehaviorParameterizationTest {
	List<Person> personList;

	@Before
	public void init() {
		personList = createDummyPersonListOnlyAge();
	}

	@Test
	public void test_person_younger_than_specific_age() {
		assertEquals(2, getPersonByCondition(personList, new YoungerThanCondition(20)).size());
	}

	@Test
	public void test_person_younger_than_specific_age_with_anonymousclass() {
		assertEquals(2, getPersonByCondition(personList, new Condition<Person>() {
			@Override
			public boolean test(Person t) {
				return t.getAge() < 20;
			}
		}).size());
	}

	public List<Person> getPersonByCondition(List<Person> personList, Condition<Person> condition) {

		List<Person> result = new ArrayList<>();

		for (Person person : personList) {
			if (condition.test(person)) {
				result.add(person);
			}
		}

		return result;
	}

	private List<Person> createDummyPersonListOnlyAge() {
		personList = new ArrayList<>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();

		person1.setAge(19);
		person2.setAge(23);
		person3.setAge(18);

		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		return personList;
	}

}

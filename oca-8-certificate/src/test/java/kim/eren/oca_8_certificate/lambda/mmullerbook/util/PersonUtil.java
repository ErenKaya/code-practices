package kim.eren.oca_8_certificate.lambda.mmullerbook.util;

import java.util.ArrayList;
import java.util.List;

import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.abstracts.Condition;
import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person;
import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person.Gender;

public class PersonUtil {

	public static List<Person> createDummyPersonListOnlyAge() {
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();

		person1.setAge(19);
		person2.setAge(23);
		person3.setAge(18);

		person1.setGender(Gender.FAMALE);
		person3.setGender(Gender.FAMALE);
		person2.setGender(Gender.MALE);

		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		return personList;
	}

	public static List<Person> getPersonByCondition(List<Person> personList, Condition<Person> condition) {

		List<Person> result = new ArrayList<>();

		for (Person person : personList) {
			if (condition.test(person)) {
				result.add(person);
			}
		}

		return result;
	}

	public static Object getVendorCount(List<Person> personList) {
		// TODO Auto-generated method stub
		return new Person();
	}

}

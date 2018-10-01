package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_7;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person;
import kim.eren.oca_8_certificate.lambda.mmullerbook.entity.Person.Gender;
import kim.eren.oca_8_certificate.lambda.mmullerbook.util.PersonUtil;

public class StreamTest {

	List<Person> personList;

	@Before
	public void init() {
		personList = PersonUtil.createDummyPersonListOnlyAge();

	}

	@Test
	public void test_famale_person_with_below_age_20() {
		List<Person> personListWithFamaleAndAgeOfBelow20 = personList.stream().filter(p -> p.getAge() < 20)
				.filter(p -> p.getGender().equals(Gender.FAMALE)).collect(Collectors.toList());
		System.out.println(new JSONArray(personListWithFamaleAndAgeOfBelow20));
		assertEquals(2, personListWithFamaleAndAgeOfBelow20.size());
	}

	@Test
	public void test_average_famale_ages_below_to_20() {
		double personAvarageFamaleAgesBelowTo20 = personList.stream()
				.filter(p -> p.getAge() < 20 && p.getGender().equals(Gender.FAMALE)).mapToInt(p -> p.getAge()).average()
				.getAsDouble();
		System.out.println(personAvarageFamaleAgesBelowTo20);
		assertEquals(18.5, personAvarageFamaleAgesBelowTo20,18.5d);
	}
}

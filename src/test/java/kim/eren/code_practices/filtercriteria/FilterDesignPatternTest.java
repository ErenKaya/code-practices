package kim.eren.code_practices.filtercriteria;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.filtercreteria.AndCriteria;
import kim.eren.code_practices.filtercreteria.Criteria;
import kim.eren.code_practices.filtercreteria.FemaleCriteria;
import kim.eren.code_practices.filtercreteria.MaleCriteria;
import kim.eren.code_practices.filtercreteria.OrCriteria;
import kim.eren.code_practices.filtercreteria.SingleCriteria;
import kim.eren.code_practices.filtercreteria.entity.Person;


public class FilterDesignPatternTest {
	List<Person> persons;
	Criteria male, female, single, singleMale, singleOrFamale;

	@Before
	public void init() {
		persons = new ArrayList<Person>();
		persons.add(new Person("Robert", "MALE", "SINGLE"));
		persons.add(new Person("John", "MALE", "MARRIED"));
		persons.add(new Person("Laura", "FEMALE", "MARRIED"));
		persons.add(new Person("Diana", "FEMALE", "SINGLE"));
		persons.add(new Person("Mike", "MALE", "SINGLE"));
		persons.add(new Person("Bobby", "MALE", "SINGLE"));
		male = new MaleCriteria();
		female = new FemaleCriteria();
		single = new SingleCriteria();
		singleMale = new AndCriteria(single, male);
		singleOrFamale = new OrCriteria(single, female);
	}

	@Test
	public void test_single_male_persons() {
		System.out.println("\nSingle Males: ");
		printPersons(singleMale.meetCriteria(persons));
	}

	@Test
	public void test_male_persons() {
		System.out.println("Males: ");
		printPersons(male.meetCriteria(persons));
	}

	@Test
	public void test_female_persons() {
		System.out.println("\nFemales: ");
		printPersons(female.meetCriteria(persons));
	}

	@Test
	public void test_single_or_female_persons() {

		System.out.println("\nSingle Or Females: ");
		printPersons(singleOrFamale.meetCriteria(persons));
	}

	public void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender()
					+ ", Marital Status : " + person.getMaritalStatus() + " ]");
		}
	}

}

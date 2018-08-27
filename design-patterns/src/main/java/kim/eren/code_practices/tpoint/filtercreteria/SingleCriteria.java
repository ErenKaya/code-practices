package kim.eren.code_practices.tpoint.filtercreteria;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.tpoint.filtercreteria.entity.Person;


public class SingleCriteria implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> singlePerson = new ArrayList();

		for (Person person : persons) {
			
			if (person.getMaritalStatus().equals("SINGLE")) {
				singlePerson.add(person);
			}
		}
		return singlePerson;
	}

}

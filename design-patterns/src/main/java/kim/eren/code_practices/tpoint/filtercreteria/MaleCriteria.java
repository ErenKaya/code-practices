package kim.eren.code_practices.tpoint.filtercreteria;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.tpoint.filtercreteria.entity.Person;

public class MaleCriteria implements Criteria {

	public List<Person> meetCriteria(List<Person> persons) {
		
		List<Person> malePerson = new ArrayList();
		
		for(Person person : persons) {
			if(person.getGender().equals("MALE")) {
				malePerson.add(person);
			}
		}
		return malePerson;
	}

}

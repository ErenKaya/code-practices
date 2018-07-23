package kim.eren.code_practices.filtercreteria;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.filtercreteria.entity.Person;

public class FemaleCriteria implements Criteria{
	
	
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> filteredPersons = new ArrayList<>();
		
		for(Person person : persons) {
			if(person.getGender().equalsIgnoreCase("FEMALE")) {
				filteredPersons.add(person);
			}
		}
		return filteredPersons; 
	}

}

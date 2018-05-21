package kim.eren.code_practices.filtercreteria;

import java.util.List;

import kim.eren.code_practices.filtercreteria.entity.Person;

public interface Criteria {
	
	public List<Person> meetCriteria(List<Person> persons);

}

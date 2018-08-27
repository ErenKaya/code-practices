package kim.eren.code_practices.tpoint.filtercreteria;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.tpoint.filtercreteria.entity.Person;

public class OrCriteria implements Criteria {

	private Criteria otherCriteria;
	private Criteria criteria;
	public OrCriteria(Criteria otherCriteria, Criteria criteria) {

		this.otherCriteria = otherCriteria;
		this.criteria = criteria;
	}

	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstFilteredCriteriaResult = criteria.meetCriteria(persons);
		List<Person> otherFilteredCriteriaResult = criteria.meetCriteria(persons);
		for(Person person : otherFilteredCriteriaResult) {
			if(!firstFilteredCriteriaResult.contains(person)) {
				firstFilteredCriteriaResult.add(person);
			}
		}
		return firstFilteredCriteriaResult;

	}

}

package kim.eren.code_practices.tpoint.filtercreteria;

import java.util.List;

import kim.eren.code_practices.tpoint.filtercreteria.entity.Person;

public class AndCriteria implements Criteria {

	private Criteria otherCriteria;
	private Criteria criteria;

	public AndCriteria(Criteria otherCriteria, Criteria criteria) {
		this.otherCriteria = otherCriteria;
		this.criteria = criteria;
	}

	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstFilteredCriteria = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstFilteredCriteria);
	}

}

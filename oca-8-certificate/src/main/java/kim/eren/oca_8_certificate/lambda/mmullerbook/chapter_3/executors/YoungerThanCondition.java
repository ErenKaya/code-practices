package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.executors;

import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.abstracts.Condition;
import kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_3.entity.Person;

public class YoungerThanCondition implements Condition<Person> {

	private final int age;

	public YoungerThanCondition(int age) {
		super();
		this.age = age;
	}

	@Override
	public boolean test(Person t) {
		return t.getAge() < this.age;
	}

}

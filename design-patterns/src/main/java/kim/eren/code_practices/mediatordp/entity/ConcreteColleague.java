package kim.eren.code_practices.mediatordp.entity;

import kim.eren.code_practices.CodePracticeResult;
import kim.eren.code_practices.mediatordp.Mediator;

public class ConcreteColleague extends Colleague {

	public ConcreteColleague(Mediator m) {
		super(m);
	}

	@Override
	public CodePracticeResult receive(String message) {
		return new CodePracticeResult("1", "message sended from concreteObj" + message);
	}

}

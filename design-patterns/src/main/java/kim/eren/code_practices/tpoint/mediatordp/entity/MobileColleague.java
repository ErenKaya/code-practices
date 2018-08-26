package kim.eren.code_practices.tpoint.mediatordp.entity;

import kim.eren.code_practices.CodePracticeResult;
import kim.eren.code_practices.tpoint.mediatordp.Mediator;

public class MobileColleague extends Colleague {

	public MobileColleague(Mediator m) {
		super(m);
	}

	@Override
	public CodePracticeResult receive(String message) {
		return new CodePracticeResult("1", "the message sended!" + message);
	}

}

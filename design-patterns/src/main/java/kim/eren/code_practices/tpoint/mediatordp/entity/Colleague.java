package kim.eren.code_practices.tpoint.mediatordp.entity;

import kim.eren.code_practices.CodePracticeResult;
import kim.eren.code_practices.tpoint.mediatordp.Mediator;

public abstract class Colleague {

	private Mediator mediator;

	public Colleague(Mediator m) {
		this.mediator = m;
	}

	public CodePracticeResult sendMessage(String message) {
		mediator.sendMessage(message, this);
		return new CodePracticeResult("1", "Colleague message send" + message);
	}
	
	public Mediator getMediator() {
		return mediator;
	}

	public abstract CodePracticeResult receive(String message);

}

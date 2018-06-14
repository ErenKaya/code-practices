package kim.eren.code_practices.mediatordp;

import kim.eren.code_practices.CodePracticeResult;
import kim.eren.code_practices.mediatordp.entity.Colleague;

public interface Mediator {
	public CodePracticeResult sendMessage(String message, Colleague colleague);
}

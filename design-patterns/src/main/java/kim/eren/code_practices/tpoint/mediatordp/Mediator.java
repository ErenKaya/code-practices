package kim.eren.code_practices.tpoint.mediatordp;

import kim.eren.code_practices.tpoint.CodePracticeResult;
import kim.eren.code_practices.tpoint.mediatordp.entity.Colleague;

public interface Mediator {
	public CodePracticeResult sendMessage(String message, Colleague colleague);
}

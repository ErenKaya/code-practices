package kim.eren.code_practices.tpoint.mediatordp;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.tpoint.CodePracticeResult;
import kim.eren.code_practices.tpoint.mediatordp.entity.Colleague;

public class ApplicationMediator implements Mediator {

	private List<Colleague> colleagueList;

	public ApplicationMediator() {
		this.colleagueList = new ArrayList<Colleague>();
	}

	public CodePracticeResult sendMessage(String message, Colleague colleague) {
		for (Colleague c : colleagueList) {
			if (!c.equals(colleague)) {
				c.receive(message);
			}
		}

		return null;
	}

	public void addColleague(Colleague colleague) {
		colleagueList.add(colleague);
	}

}

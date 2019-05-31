package kim.eren.code_practices.tpoint.observerdp;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observerList = new ArrayList<Observer>();
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void attach(Observer observer) {
		observerList.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observerList) {
			observer.update();
		}
	}

}

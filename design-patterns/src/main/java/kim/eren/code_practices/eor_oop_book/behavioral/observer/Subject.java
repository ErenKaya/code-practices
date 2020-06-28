package kim.eren.code_practices.eor_oop_book.behavioral.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		Iterator<Observer> observersIterator = observers.iterator();
		while (observersIterator.hasNext()) {
			Observer ob = observersIterator.next();
			ob.update(this);
		}
	}

}

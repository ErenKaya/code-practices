package kim.eren.code_practices.eor_oop_book.behavioral.observer;

public abstract class Observer {

	public Observer(ClockTimer timer) {
		timer.attach(this);
	}

	abstract void update(Subject s);
}

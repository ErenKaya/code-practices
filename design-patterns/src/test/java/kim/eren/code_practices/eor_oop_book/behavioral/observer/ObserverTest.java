package kim.eren.code_practices.eor_oop_book.behavioral.observer;

public class ObserverTest {

	public static void main(String[] args) throws InterruptedException {
		ClockTimer timer = new ClockTimer();
		new AnalogClock(timer);
		new DigitalClock(timer);
		timer.tick();
	}

}

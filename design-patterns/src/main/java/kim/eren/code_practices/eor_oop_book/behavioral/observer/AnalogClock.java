
package kim.eren.code_practices.eor_oop_book.behavioral.observer;

public class AnalogClock extends Observer {

	public AnalogClock(ClockTimer timer) {
		super(timer);
	}

	@Override
	public void update(Subject s) {
		draw((ClockTimer) s);
	}

	private void draw(ClockTimer s) {
		System.out
				.println("AnalogClock hour:" + s.getHour() + " minute:" + s.getMinute() + " seconds:" + s.getSecond());
	}

}

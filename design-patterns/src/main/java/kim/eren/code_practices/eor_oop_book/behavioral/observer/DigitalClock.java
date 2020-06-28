package kim.eren.code_practices.eor_oop_book.behavioral.observer;

public class DigitalClock extends Observer {

	public DigitalClock(ClockTimer timer) {
		super(timer);
	}

	@Override
	public void update(Subject s) {
		draw((ClockTimer) s);
	}

	private void draw(ClockTimer s) {
		System.out
				.println("DigitalClock hour:" + s.getHour() + " minute:" + s.getMinute() + " seconds:" + s.getSecond());
	}

}

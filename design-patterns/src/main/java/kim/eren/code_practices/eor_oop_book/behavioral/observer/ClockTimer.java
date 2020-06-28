package kim.eren.code_practices.eor_oop_book.behavioral.observer;

public class ClockTimer extends Subject {
	public int count;

	public ClockTimer() throws InterruptedException {
	}

	public int getHour() {
		return this.getMinute() / 60;
	}

	public int getMinute() {
		return this.getSecond() / 60;
	}

	public int getSecond() {
		return count;
	}

	public void tick() throws InterruptedException {
		for (;;) {
			Thread.sleep(1000);
			count++;
			notifyObservers();
		}
	}
}

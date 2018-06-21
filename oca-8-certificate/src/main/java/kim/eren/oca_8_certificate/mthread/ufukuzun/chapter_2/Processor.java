package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_2;

public class Processor {

	private volatile static Integer number = 0;
	

    public static void init() {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = number;
			while (local_value < 5) {
				
				if (local_value != number) {
					System.out.println("Got Change for MY_INT : "+ number);
					local_value = number;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int local_value = number;
			while (number < 5) {
				System.out.println("Incrementing MY_INT to : "+ (local_value + 1));
				number = ++local_value;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

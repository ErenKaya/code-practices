package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_3;

public class Application {

	private int count = 0;

	/**
	 * if you delete that method you can see synchronized bug two thread attempt to
	 * change count value in same time to change one of thread not worked
	 * 
	 * @return
	 */
	public /* you can delete the syncronized keyword and watch the program behavior */
	synchronized void incrementCount() {
		++count;
	}

	public void doCount() {

		Thread firstThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount();
				}

			}
		});

		Thread secondThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCount();
				}
			}
		});

		firstThread.start();
		secondThread.start();
		try {
			firstThread.join();
			secondThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Threads started! count: " + count);

	}
}

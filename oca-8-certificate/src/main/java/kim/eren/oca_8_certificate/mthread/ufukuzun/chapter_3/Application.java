package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_3;

public class Application {

	private int count = 0;

	/**
	 * if you delete that method you can see synchronized bug two thread attempt to
	 * change count value in same time to change one of thread not worked
	 * 
	 * @return
	 */
	private /* you can delete the syncronized keyword and watch the program behavior */
	synchronized void incrementCount() {
		++count;
	}

	private void incrementCountWithoutSync() {
		++count;
	}

	/**
	 * that method execute two thread with your one parameter which is maxValue two
	 * thread have a loop which is increments count to your maxValue;
	 * 
	 * @param maxValue
	 */
	public void doCount(int maxValue, boolean synchronizedOff) {

		Thread firstThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < maxValue; i++) {
					if (synchronizedOff) {
						incrementCount();
					} else {
						incrementCountWithoutSync();
					}
				}

			}

		});

		Thread secondThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < maxValue; i++) {
					if (synchronizedOff) {
						incrementCount();
					} else {
						incrementCountWithoutSync();
					}
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

	public int getCount() {
		return count;
	}
}

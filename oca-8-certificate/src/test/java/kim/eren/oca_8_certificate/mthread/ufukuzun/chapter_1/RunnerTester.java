package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;

public class RunnerTester {

	private List<Runner> runnerList;

	@Before
	public void init() {
		runnerList = new ArrayList<Runner>();
		runnerList.add(new Runner());
		runnerList.add(new Runner());
	}

	@Test
	public void test_only_one_runner() {
		runnerList.get(0).start();
	}

	@Test
	public void test_two_runner() {
		runnerList.get(0).start();
		runnerList.get(1).start();
	}

	@Test
	public void test_random_count_for_0_to_10_runner() {
		int runnerCount = ThreadLocalRandom.current().nextInt(1, 20 + 1);
		for (int i = 0; i < runnerCount; i++) {
			System.out.println("new runner created : " + i);
			new Runner().start();
		}
	}

	@Test
	public void test_lambda_single_line_multitthread() {
		Thread thread = new Thread(() -> {
			System.out.println("Single line");
		});
		thread.start();
	}

}

package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

	Application app;

	@Before
	public void init() {
		app = new Application();
	}

	@Test
	public void test_worst_case_with_scyronized_keyword() {
		app.doCount(10000, true);
		assertEquals(20000, app.getCount());
	}

	@Test
	public void test_worst_case_without_scyronized_keyword() {
		app.doCount(100000, false);
		assertNotEquals(20000, app.getCount());
	}

}

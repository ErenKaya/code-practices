package kim.eren.oca_8_certificate.mthread.ufukuzun.chapter_3;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
	
	Application app;
	
	@Before
	public void init() {
		app = new Application();
	}
	
	@Test
	public void test_worst_case_without_scyronized_keyword() {
		app.doCount();
	}

}

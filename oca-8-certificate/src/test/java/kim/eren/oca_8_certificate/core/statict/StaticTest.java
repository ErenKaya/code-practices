package kim.eren.oca_8_certificate.core.statict;

import org.junit.Before;
import org.junit.Test;

/**
 * Static blocks always executed only one time.
 * instance block always executed every instance created.
 * static block not allow to use this keyword but you can use in instance block
 * @author eren
 *
 */
public class StaticTest {
	
	private StaticClass sClassWithParameter;
	private StaticClass sClassWithOutParameter;
	
	@Before
	public void init() {
		sClassWithParameter = new StaticClass();
		sClassWithOutParameter = new StaticClass(10);
	}
	
	@Test
	public void test_empty_classes() {
//		System.out.println("end");
	}
	
}

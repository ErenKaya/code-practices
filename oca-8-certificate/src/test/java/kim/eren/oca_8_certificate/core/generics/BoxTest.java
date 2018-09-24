package kim.eren.oca_8_certificate.core.generics;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {

	Box<Integer> intBox;

	@Before
	public void init() {
		intBox = new Box<Integer>();
	}

	@Test
	public void test_box_setter_getter() {
//		intBox.setT(10l); Compile  error because integerBox created with Integer so you cannot set long variables
		intBox.setT(10);
		assertEquals((Integer) 10, intBox.getT());
	}

}

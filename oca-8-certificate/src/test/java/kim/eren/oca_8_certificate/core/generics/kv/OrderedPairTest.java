package kim.eren.oca_8_certificate.core.generics.kv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderedPairTest {
	OrderedPair<String, Integer> orderedPair1;
	OrderedPair<String, Integer> orderedPair2;

	@Before
	public void init() {
		orderedPair1 = new OrderedPair<String, Integer>();
		orderedPair2 = new OrderedPair<String, Integer>();
		orderedPair1.setKey("Key");
		orderedPair1.setValue(10);
		orderedPair2.setKey("Key");
		orderedPair2.setValue(10);
	}

	@Test
	public void test_box_setter_getter() {
		assertEquals((Integer) 10, orderedPair1.getValue());
	}

	@Test
	public void test_util_compare_method() {
		// If you ignore Util.<String,Integer> declarations still compiler compile that.
		assertTrue(Util.<String, Integer>compare(orderedPair1, orderedPair2));
	}
}

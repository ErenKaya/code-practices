package kim.eren.oca_8_certificate.core.gk;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class DequeTest {

	DequeExample ex;

	@Before
	public void init() {
		ex = new DequeExample();
		ex.dExample = new LinkedList();
	}

	@Test
	public void test_deque_add_first_method() {
		// Adding to first element
		ex.dExample.addFirst("First");
		// Again
		ex.dExample.addFirst("Two");
		assertEquals("Two", ex.dExample.getFirst());
	}

	@Test
	public void test_deque_add_last_method() {
		ex.dExample.addLast("Last 1");
		ex.dExample.addLast("Last 2");
		assertEquals("Last 2", ex.dExample.getLast());
	}

	@Test
	public void test_deque_pop_method() {
		createDummyData();
		Object removedItem = ex.dExample.pop();
		assertEquals(createExpectation(), ex.dExample);
	}

	private Object createExpectation() {
		Deque object = new LinkedList();
		object.add("2");
		object.add("3");
		object.add("4");
		return object;
	}

	private void createDummyData() {
		ex.dExample.add("1");
		ex.dExample.add("2");
		ex.dExample.add("3");
		ex.dExample.add("4");
	}

}

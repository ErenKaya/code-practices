package kim.eren.code_practices.iteratordp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IteratorDesignPatternTest {
	NameRepository nameRepository;

	@Before
	public void init() {
		nameRepository = new NameRepository();
	}

	@Test
	public void test_first_element_from_iterator() {
		Iterator iterator = nameRepository.getIterator();
		iterator.hasNext();
		assertEquals("Eren", (String) iterator.next());

	}

	@Test
	public void test_all_elements_with_iterator() {
		int i = nameRepository.names.length;
		int forCounter = 0;
		for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			System.out.println("name: " + name);
			forCounter++;
		}
		assertEquals(i, forCounter);

	}

}

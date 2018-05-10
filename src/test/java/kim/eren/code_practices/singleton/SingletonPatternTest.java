package kim.eren.code_practices.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SingletonPatternTest {
	
	private String objectHashCode;
	
	@Before
	public void init() {
		objectHashCode = SingletonObject.getInstance().toString();
	}
	
	@Test
	public void object_created_only_one_time_test() {
		SingletonObject singleObject = SingletonObject.getInstance();
		assertEquals(objectHashCode, singleObject.toString());
	}

}

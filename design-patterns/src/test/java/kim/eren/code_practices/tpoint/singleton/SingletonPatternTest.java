package kim.eren.code_practices.tpoint.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.singleton.SingletonObject;
import kim.eren.code_practices.tpoint.singleton.SingletonObjectTwo;

public class SingletonPatternTest {
	
	private String objectHashCode;
	private String objectHashCode2;
	
	@Before
	public void init() {
		objectHashCode = SingletonObject.getInstance().toString();
		objectHashCode2 = SingletonObjectTwo.getInstance().toString();
	}
	
	@Test
	public void object_created_only_one_time_test() {
		SingletonObject singleObject = SingletonObject.getInstance();
		assertEquals(objectHashCode, singleObject.toString());
	}
	
	@Test
	public void object2_created_only_one_time_test() {
		SingletonObjectTwo objectTwo = SingletonObjectTwo.getInstance();
		assertEquals(objectHashCode2, objectTwo.toString());
	}

}

package kim.eren.code_practices.tpoint.facedepattern;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.facedepattern.FacedeFactory;

public class FacedePatternTest {

	private FacedeFactory facedeFactory;

	@Before
	public void init() {
		facedeFactory = FacedeFactory.getInstance();
	}
	
	@Test
	public void facede_impl_test() {
		facedeFactory.getFacede().doSomething();;
	}

}

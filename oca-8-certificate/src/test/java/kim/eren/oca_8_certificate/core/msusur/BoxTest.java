package kim.eren.oca_8_certificate.core.msusur;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {

	Box box;

	@Before
	public void init() {

	}

	@Test
	public void test_box_print() {
		box = new Box(new Wall(10, Side.HORIZONTAL), new Wall(10, Side.VERTICAL), new Wall(10, Side.HORIZONTAL));
		System.out.println((box.printBox()));
	}

}

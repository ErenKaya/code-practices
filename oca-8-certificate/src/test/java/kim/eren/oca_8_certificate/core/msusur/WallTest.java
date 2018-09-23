package kim.eren.oca_8_certificate.core.msusur;

import org.junit.Test;

public class WallTest {

	@Test
	public void test_right_left_wall_string() {
		System.out.println(WallBuilder.printWall(new Wall(10, Side.HORIZONTAL)));
	}

}

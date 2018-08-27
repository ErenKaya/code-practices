package kim.eren.code_practices.tpoint.bridgedp;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.bridgedp.Circle;
import kim.eren.code_practices.tpoint.bridgedp.GreenCircle;
import kim.eren.code_practices.tpoint.bridgedp.RedCircle;
import kim.eren.code_practices.tpoint.bridgedp.Shape;

public class BridgeDesignPatternTest {
	Shape shape;

	@Before
	public void init() {

	}

	@Test
	public void test_green_circle_draw() {
		shape = new Circle(100, 100, 10, new GreenCircle());
		shape.draw();
	}
	
	@Test
	public void test_red_circle_draw() {
		shape = new Circle(100, 100, 8, new RedCircle());
		shape.draw();
	}

}

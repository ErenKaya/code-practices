package kim.eren.code_practices.tpoint.decoratordp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.decoratordp.entity.Circle;
import kim.eren.code_practices.tpoint.decoratordp.entity.Rectangle;
import kim.eren.code_practices.tpoint.decoratordp.entity.RedShapeDecorator;
import kim.eren.code_practices.tpoint.decoratordp.entity.Shape;

public class DecoratorPatternTest {
	

	Shape normalCircle, rectangleWithBorder, circleWithBorder;
	StringBuilder stringBuilder;
	@Before
	public void init() {
		normalCircle = new Circle();
		rectangleWithBorder = new RedShapeDecorator(new Rectangle());
		circleWithBorder = new RedShapeDecorator(new Circle());
	}
	@Test
	public void test_rectangle_with_red_border() {
		String expectedValue = doStringOperations(rectangleWithBorder);
		assertEquals("Red|Rectangle|", expectedValue);
	}
	
	@Test
	public void test_circle_with_red_border() {
		String expectedValue = doStringOperations(circleWithBorder);
		assertEquals("Red|Circle|", expectedValue);
	}
	
	
	
	
	protected String doStringOperations(Shape shape) {
		stringBuilder = new StringBuilder();
		String[] splittedExpected = shape.draw().split("-");
		for(String expected : splittedExpected) {
			stringBuilder.append(expected.substring(expected.indexOf(":")+1, expected.length()));
			stringBuilder.append("|");
		}
		
		return stringBuilder.toString();
	}

}

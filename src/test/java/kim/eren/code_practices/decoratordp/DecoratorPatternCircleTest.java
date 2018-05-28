package kim.eren.code_practices.decoratordp;

import org.junit.Test;

import kim.eren.code_practices.decoratordp.entity.Shape;

public class DecoratorPatternCircleTest extends DecoratorPatternTest{
	
	

	@Override
	public void init() {
		super.init();
	}
	
	@Test
	public void test_normal_circle() {
		String expectedValue = doStringOperations(normalCircle);
	}
	
	

	@Override
	public void test_rectangle_with_red_border() {
		
	}

	@Override
	public void test_circle_with_red_border() {
	
	}

	@Override
	protected String doStringOperations(Shape shape) {
		stringBuilder = new StringBuilder();
		String expectedValueFromCircle = normalCircle.draw();
		stringBuilder.append(expectedValueFromCircle.substring(expectedValueFromCircle.indexOf(":")+1, expectedValueFromCircle.length()));
		return stringBuilder.toString();
	}

	
	
}

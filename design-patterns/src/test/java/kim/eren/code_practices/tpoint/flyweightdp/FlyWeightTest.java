package kim.eren.code_practices.tpoint.flyweightdp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kim.eren.code_practices.CodePracticeResult;
import kim.eren.code_practices.tpoint.flyweightdp.ShapeFactory;
import kim.eren.code_practices.tpoint.flyweightdp.entity.Circle;

public class FlyWeightTest {
	private final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
	
	
	@Test
	public void test_100_times_object_generation_trace_colors() {
		for(int i = 0; i<100;i++) {
			Circle circle = (Circle) ShapeFactory.getShape(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			CodePracticeResult result= circle.draw();
			assertEquals("1", result.getResultId());
			System.out.println(result.getResultText());
		}
	}

	private String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private int getRandomY() {
		return (int) (Math.random() * 100);
	}
}

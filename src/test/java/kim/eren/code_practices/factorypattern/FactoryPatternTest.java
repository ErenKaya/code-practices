package kim.eren.code_practices.factorypattern;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.factorypattern.ShapeFactory;
import kim.eren.code_practices.factorypattern.entities.Circle;
import kim.eren.code_practices.factorypattern.entities.Rectangle;
import kim.eren.code_practices.factorypattern.entities.Square;
import kim.eren.code_practices.factorypattern.enums.ShapeType;
import kim.eren.code_practices.factorypattern.interfaces.Shape;

public class FactoryPatternTest {
	
	private Shape shape;
	ShapeFactory shapeFactory;
	
	@Before
	public void init_shape() {
		shapeFactory  = new ShapeFactory();
	}

	@Test
	public void factory_pattern_rectangle_object_test() {
		shape = shapeFactory.getShape(ShapeType.RECTANGLE.toString());
		assertEquals("rectangle", getResult(shape));
	}
	
	@Test
	public void factory_pattern_circle_object_test() {
		shape = shapeFactory.getShape(ShapeType.CIRCLE.toString());
		assertEquals("circle", getResult(shape));
	}
	@Test
	public void factory_pattern_square_object_test() {
		shape = shapeFactory.getShape(ShapeType.SQUARE.toString());
		assertEquals("square", getResult(shape));
	}
	@Test
	public void factory_pattern_null_test() {
		shape = shapeFactory.getShape("");
		assertEquals(null, getResult(shape));
	}
	
	@Test
	public void factory_pattern_draw_test() {
		shape = shapeFactory.getShape(ShapeType.SQUARE.toString());
		shape.draw();
		shape = shapeFactory.getShape(ShapeType.CIRCLE.toString());
		shape.draw();
		shape = shapeFactory.getShape(ShapeType.RECTANGLE.toString());
		shape.draw();
	}
	
	public String getResult(Shape shape) {
		if (shape instanceof Rectangle) {
			return "rectangle";
		}else if(shape instanceof Circle){
			return "circle";
		}else if(shape instanceof Square){
			return "square";
		}else {
			return null;
		}
	}

}

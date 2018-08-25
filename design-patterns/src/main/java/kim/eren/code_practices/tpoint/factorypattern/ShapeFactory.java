package kim.eren.code_practices.tpoint.factorypattern;

import kim.eren.code_practices.tpoint.abstractfactories.AbstractFactory;
import kim.eren.code_practices.tpoint.factorypattern.entities.Circle;
import kim.eren.code_practices.tpoint.factorypattern.entities.Rectangle;
import kim.eren.code_practices.tpoint.factorypattern.entities.Square;
import kim.eren.code_practices.tpoint.factorypattern.enums.ShapeType;
import kim.eren.code_practices.tpoint.factorypattern.interfaces.Shape;

public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType.equals(ShapeType.CIRCLE.toString())) {
			return new Circle();
		} else if (shapeType.equals(ShapeType.RECTANGLE.toString())) {
			return new Rectangle();
		} else if (shapeType.equals(ShapeType.SQUARE.toString())) {
			return new Square();
		} else {
			return null;
		}

	}

}

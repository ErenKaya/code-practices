package kim.eren.code_practices.factorypattern;

import kim.eren.code_practices.abstractfactories.AbstractFactory;
import kim.eren.code_practices.factorypattern.entities.Circle;
import kim.eren.code_practices.factorypattern.entities.Rectangle;
import kim.eren.code_practices.factorypattern.entities.Square;
import kim.eren.code_practices.factorypattern.enums.ShapeType;
import kim.eren.code_practices.factorypattern.interfaces.Shape;

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

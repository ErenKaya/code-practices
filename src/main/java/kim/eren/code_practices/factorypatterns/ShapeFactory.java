package kim.eren.code_practices.factorypatterns;

import kim.eren.code_practices.abstractfactories.AbstractFactory;
import kim.eren.code_practices.factorypatterns.entities.Circle;
import kim.eren.code_practices.factorypatterns.entities.Rectangle;
import kim.eren.code_practices.factorypatterns.entities.Square;
import kim.eren.code_practices.factorypatterns.enums.ShapeType;
import kim.eren.code_practices.factorypatterns.interfaces.Shape;

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

import kim.eren.code_practices.factorypatterns.ShapeFactory;
import kim.eren.code_practices.factorypatterns.entities.Rectangle;
import kim.eren.code_practices.factorypatterns.enums.ShapeType;
import kim.eren.code_practices.factorypatterns.interfaces.Shape;

public class App {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("asdfg");
		if(shape1 instanceof Rectangle) {
			System.out.println("Rectangle correct result");
		}else if(shape1 == null) {
			System.out.println("Hatalı");
		}
	}

}

package kim.eren.code_practices.tpoint.flyweightdp;

import java.util.HashMap;
import java.util.Map;

import kim.eren.code_practices.tpoint.flyweightdp.entity.Circle;
import kim.eren.code_practices.tpoint.flyweightdp.entity.Shape;

public class ShapeFactory {

	public static Map<String, Circle> circleMap = new HashMap<String, Circle>();

	public static Shape getShape(String color) {
		Circle circle = (Circle) circleMap.get(color);
		if (circle == null) {
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("New circle creating with " + color);
		}
		return circle;
	}

}

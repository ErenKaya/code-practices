package kim.eren.code_practices.tpoint.abstractfactories;

import kim.eren.code_practices.tpoint.abstractfactories.enums.FactoryType;
import kim.eren.code_practices.tpoint.factorypattern.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factoryType) {
		if (factoryType != null) {
			if (factoryType.equals(FactoryType.SHAPE.toString())) {
				return new ShapeFactory();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}

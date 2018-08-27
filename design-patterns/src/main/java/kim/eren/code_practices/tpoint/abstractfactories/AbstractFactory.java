package kim.eren.code_practices.tpoint.abstractfactories;

import kim.eren.code_practices.tpoint.factorypattern.interfaces.Shape;

public abstract class AbstractFactory {
	public abstract Shape getShape(String shape);
}

package kim.eren.code_practices.abstractfactories;

import kim.eren.code_practices.factorypattern.interfaces.Shape;

public abstract class AbstractFactory {
	public abstract Shape getShape(String shape);
}

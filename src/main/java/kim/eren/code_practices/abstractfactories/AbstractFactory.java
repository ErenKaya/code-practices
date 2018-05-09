package kim.eren.code_practices.abstractfactories;

import kim.eren.code_practices.factorypatterns.interfaces.Shape;

public abstract class AbstractFactory {
	public abstract Shape getShape(String shape);
}

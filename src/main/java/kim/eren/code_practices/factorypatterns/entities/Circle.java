package kim.eren.code_practices.factorypatterns.entities;

import kim.eren.code_practices.factorypatterns.interfaces.Shape;

public class Circle implements Shape {

	public void draw() {
		System.out.println("Circle, drawing.");
	}

}

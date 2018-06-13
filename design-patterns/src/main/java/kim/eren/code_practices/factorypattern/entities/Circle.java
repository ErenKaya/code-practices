package kim.eren.code_practices.factorypattern.entities;

import kim.eren.code_practices.factorypattern.interfaces.Shape;

public class Circle implements Shape {

	public void draw() {
		System.out.println("Circle, drawing.");
	}

}

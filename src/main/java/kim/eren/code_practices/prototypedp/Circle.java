package kim.eren.code_practices.prototypedp;

public class Circle extends Shape {

	public Circle() {
		super.type = "circle";
	}

	@Override
	void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}

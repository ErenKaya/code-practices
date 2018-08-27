package kim.eren.code_practices.tpoint.prototypedp;

public class Circle extends Shape {

	public Circle() {
		super.type = "circle";
	}

	@Override
	void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}

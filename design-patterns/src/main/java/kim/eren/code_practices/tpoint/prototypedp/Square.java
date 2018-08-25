package kim.eren.code_practices.tpoint.prototypedp;

public class Square extends Shape {

	public Square() {
		super.type = "square";
	}

	@Override
	void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}

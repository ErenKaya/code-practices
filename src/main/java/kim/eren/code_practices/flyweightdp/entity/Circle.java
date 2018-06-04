package kim.eren.code_practices.flyweightdp.entity;

import kim.eren.code_practices.CodePracticeResult;

public class Circle implements Shape {

	private String color;
	private int x;
	private int y;
	private int radius;

	
	public Circle() {

	}

	public Circle(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public CodePracticeResult draw() {
		CodePracticeResult result = new CodePracticeResult();
		result.setResultId("1");
		result.setResultText("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
		return result;
	}

}

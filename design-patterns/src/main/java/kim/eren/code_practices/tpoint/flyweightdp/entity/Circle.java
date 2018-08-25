package kim.eren.code_practices.tpoint.flyweightdp.entity;

import kim.eren.code_practices.tpoint.CodePracticeResult;

public class Circle implements Shape {

	private String color;
	private int x;
	private int y;
	private int radius;

	


	public Circle(String color) {
		super();
		this.color = color;
	}



	public void setX(int x) {
		this.x = x;
	}



	public void setY(int y) {
		this.y = y;
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

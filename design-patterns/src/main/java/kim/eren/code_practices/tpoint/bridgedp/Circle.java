package kim.eren.code_practices.tpoint.bridgedp;

public class Circle extends Shape {
	private int x, y, radius;

	public Circle(int x, int y,int radius, DrawApi drawApi) {
		super(drawApi);
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw() {
		drawApi.drawCircle(radius, x, y);
	}

}

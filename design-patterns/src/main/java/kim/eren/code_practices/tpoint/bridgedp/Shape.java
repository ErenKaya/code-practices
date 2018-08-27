package kim.eren.code_practices.tpoint.bridgedp;

public abstract class Shape {

	protected DrawApi drawApi;

	public Shape(DrawApi drawApi) {
		this.drawApi = drawApi;
	}
	public abstract void draw();	
}

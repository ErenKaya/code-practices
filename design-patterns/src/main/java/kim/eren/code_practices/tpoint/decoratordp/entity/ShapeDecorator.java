package kim.eren.code_practices.tpoint.decoratordp.entity;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		super();
		this.decoratedShape = decoratedShape;
	}

	public String draw() {
		return decoratedShape.draw();
	}

}

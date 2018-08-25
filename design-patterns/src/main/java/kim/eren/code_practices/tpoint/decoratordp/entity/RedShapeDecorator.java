package kim.eren.code_practices.tpoint.decoratordp.entity;

public class RedShapeDecorator extends ShapeDecorator{

	
	
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public String draw() {
		return borderColor(decoratedShape) +"-"+ decoratedShape.draw();
	}
	
	public String borderColor(Shape decoratedShape) {
		return "Border Color :Red";
	}

}

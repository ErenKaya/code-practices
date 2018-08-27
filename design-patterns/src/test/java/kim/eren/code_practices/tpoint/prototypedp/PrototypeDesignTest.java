package kim.eren.code_practices.tpoint.prototypedp;

import org.junit.Test;

import kim.eren.code_practices.tpoint.prototypedp.Shape;
import kim.eren.code_practices.tpoint.prototypedp.ShapeCache;

public class PrototypeDesignTest {

	@Test
	public void test_all_cloning_instance() {
		ShapeCache.loadCache();
		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
	}

}

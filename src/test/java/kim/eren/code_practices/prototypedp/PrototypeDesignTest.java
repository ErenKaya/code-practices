package kim.eren.code_practices.prototypedp;

import org.junit.Test;

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

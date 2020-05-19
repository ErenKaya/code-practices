package kim.eren.ocp.study_guide.chapter1.classes;

public class StaticNestedClass {

	private static class Nested {
		private int length = 3;
	}

	public static void main(String[] args) {
		test_static_nested_class();
	}

	private static void test_static_nested_class() {
		Nested n = new Nested();
		System.out.println("StaticNestedClass.test_static_nested_class()  " + n.length);
		;
	}
}

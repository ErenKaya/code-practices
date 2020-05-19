package kim.eren.ocp.study_guide.chapter1.classes;

/**
 * ■ They do not have an access specifier. </br>
 * ■ They cannot be declared static and cannot declare static fields or methods.
 * ■ They have access to all fields and methods of the enclosing class. ■ They
 * do not have access to local variables of a method unless those variables are
 * final or effectively final. More on this shortly.
 * 
 * @author erenk
 *
 */
public class LocalInnerClass {
	private int length = 3;

	public void calculate() {
		final int width = 20;

		class InnerClass {
			public void calculate() {
				System.out.println(LocalInnerClass.this.length * width);
			}
		}
		InnerClass iClass = new InnerClass();
		iClass.calculate();
	}

	public static void main(String[] args) {
		test_inner_class();
	}

	private static void test_inner_class() {
		LocalInnerClass lInnerClass = new LocalInnerClass();
		lInnerClass.calculate();

	}
}

package kim.eren.ocp.study_guide.chapter1.classes;

/**
 * A member inner class is defined at the member level of a class
 * 
 * @author erenk
 *
 */
public class MemberInnerClass {

	private String sameLevelVariableWithMemberClass = "Eren";

	/**
	 * Cannot declare static fields or methods Can access members of the outer class
	 * including private members
	 */
	private class MemberClass {
		private int repeat = 3;

		public void go() {
			// if you want to use this
			// this related with inner class
			for (int i = 0; i < this.repeat; i++) {
				// what if you need outer class this object?
				// you can use with <clazzname>.this.<memberofyouneedtouse>
				System.out.println(MemberInnerClass.this.sameLevelVariableWithMemberClass);
			}

		}

	}

	public void callInner() {
		MemberClass mClass = new MemberClass();
		mClass.go();
	}

	public static void main(String[] args) {
		MemberInnerClass mInnerClass = new MemberInnerClass();
		mInnerClass.callInner();
		test_inner_class_with_dot_notation();
	}

	public static void test_inner_class_with_dot_notation() {
		System.out.println("MemberInnerClass.test_inner_class_with_dot_notation()");
		MemberClass mClass = new MemberInnerClass().new MemberClass();
		mClass.go();
	}
}

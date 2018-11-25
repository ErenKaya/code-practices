package kim.eren.oca_8_certificate.oca_study_guide.chapter2;

class A {
	public Integer x;

	public Integer getValue() {
		return x;
	}
}

public class Logical {

	public static void main(String[] args) {
		A xA = getA();
		boolean result = false;
		/**
		 * if you choose shortcruit logical exp. you never get a nullpointerexception if
		 * a object == null then but you can create a object but you can not assign any
		 * value for x. thrown a n.p.e;
		 */
		if (xA != null && xA.getValue() < 5) {
			result = false;
		} else {
			result = true;
		}

		System.out.println(result);

		int x = 6;
		boolean y = (x >= 6) || (++x <= 7);
		System.out.println(x);
		/**
		 * Because x >= 6 is true , the increment operator on the right-hand side of the
		 * expression is never evaluated, so the output is 6 .
		 */
		int xB = 0;
		for (long yB = 0, z = 4; xB < 5 && yB < 10; xB++, yB++) {
			System.out.print(xB + " ");
			System.out.print(yB + " ");
		}

		System.out.println();
		System.out.println(x);
	}

	private static A getA() {
		A a = new A();
		a.x = 3;
		return a;
	}

}

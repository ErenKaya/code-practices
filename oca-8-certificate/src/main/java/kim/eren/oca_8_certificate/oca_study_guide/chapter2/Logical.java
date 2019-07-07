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
		
		Integer negativeIntegerPoint = Integer.MAX_VALUE + 1;
		System.out.println("Logical.main() positive int value " + Integer.MAX_VALUE);
		System.out.println("Logical.main() negative int value " + negativeIntegerPoint);
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
		if (12 > 10)
			System.out.println("To Low");
		else
			System.out.println("asdffhg");
		/**
		 * that line doesn't compile
		 */
		// else System.out.println("asdfg");
		boolean xBx = true, zBx = false;
		int yBx = 20;
		int xBx2;
		xBx = (yBx != 10) ^ (zBx = false);
		System.out.println(xBx + " " + yBx + "" + zBx);
		int xx = 5 * 4 % 3;
		System.out.println(xx);

		if (zBx = true)
			System.out.println("succs");
		else
			System.out.println("failure");
		/**
		 * that 3 while line will not compile because variable out of scope
		 */
		// do {
		// int yWhile = 1;
		// System.out.print(yWhile++ + " ");
		// } while (yWhile <= 10);

		int count = 0;
		ROW_LOOP: for (int row = 1; row <= 3; row++)

			for (int col = 1; col <= 2; col++) {

				if (row * col % 2 == 0)
					continue ROW_LOOP;

				count++;

			}
		System.out.println("count" + count);
	}

	private static A getA() {
		A a = new A();
		a.x = 3;
		return a;
	}

}

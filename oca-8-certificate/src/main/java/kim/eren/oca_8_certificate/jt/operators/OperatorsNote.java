package kim.eren.oca_8_certificate.jt.operators;

/**
 * <p>
 * When using the instanceof operator, keep in mind that null is not an instance
 * of anything.
 * </p>
 * 
 * <p>
 * if increment operator right side of the value first executed operations then
 * increment operation executed.
 * </p>
 * 
 * @author eren
 *
 */
public class OperatorsNote {
	public static void main(String[] args) {

		int bitmask = 0x000F;
		int val = 0x2222;
		// prints "2"
		System.out.println(val & bitmask);

		int i = 10;
		int n = i++ % 5;

		System.out.printf("i %d, n=%d", i, n);
	}
}

package kim.eren.oca_8_certificate.jt.languagebasic.variables;

/**
 * *
 * <h1>Java have defines the following kind of variables</h1>
 * <ul>
 * <li>Instance Variables(NonStatic)</li>
 * <p>
 * That values unique for each instance of object.
 * </p>
 * <li>Class Variables(Static)</li>
 * <p>
 * This variables tells compiler that there is exacly one variable
 * </p>
 * <li>Local Variables</li>
 * <p>
 * As such, local variables are only visible to the methods in which they are
 * declared; they are not accessible from the rest of the class.
 * </p>
 * <li>
 * <h1>Parameters</h1></li>
 * <p>
 * The important thing to remember is that parameters are always classified as
 * "variables" not "fields".
 * </p>
 * </ul>
 * 
 * <h2>Primitive Data Types</h2>
 * <p>
 * primitive has an initial value as you see in output of cadence // 0
 * </p>
 * <li>Byte</li>
 * <p>

 
 * @author eren
 *
 */
public class Variables {
	static int cadence;
	int speed = 0;
	int gear = 1;
	// Invalid: cannot put underscores
	// adjacent to a decimal point
	// float pi1 = 3_.1415F;
	// Invalid: cannot put underscores
	// adjacent to a decimal point
	// float pi2 = 3._1415F;
	// Invalid: cannot put underscores
	// prior to an L suffix
	// long socialSecurityNumber1 = 999_99_9999_L;

	// OK (decimal literal)
	int x1 = 5_2;
	// Invalid: cannot put underscores
	// At the end of a literal
	// int x2 = 52_;
	// OK (decimal literal)
	 int x3 = 5_______2;

	// Invalid: cannot put underscores
	// in the 0x radix prefix
	// int x4 = 0_x52;
	// Invalid: cannot put underscores
	// at the beginning of a number
	// int x5 = 0x_52;
	// OK (hexadecimal literal)
	int x6 = 0x5_2;
	// Invalid: cannot put underscores
	// at the end of a number
	// int x7 = 0x52_;

	public static void main(String[] args) {
		System.out.println(cadence);
	}

}

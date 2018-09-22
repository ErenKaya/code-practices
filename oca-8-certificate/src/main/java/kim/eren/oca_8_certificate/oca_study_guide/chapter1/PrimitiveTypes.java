package kim.eren.oca_8_certificate.oca_study_guide.chapter1;

public class PrimitiveTypes {
	// long max = 348347834873; Does not compile because we should add end of the
	// value "L" letter
	long max = 348347834873L;

	/**
	 * <ul>
	 * <li>underscores ignored from compiler</li>
	 * <li>underscores supply most readable numbers</li>
	 * </ul>
	 */
	int million1 = 1_000_000;

	public static void main(String[] args) {
		PrimitiveTypes types = new PrimitiveTypes();
		System.out.println(types.million1);
	}

	java.util.Date today;
	String greeting;
	/**
	 * <ul>
	 * <li>(1) A reference can be assigned to another object of the same type.</li>
	 * <li>(2) A reference can be assigned to a new object using the new
	 * keyword.</li>
	 * </ul>
	 */
	{
		greeting = "Hello from java";
		today = new java.util.Date();
	}
	/**
	 * <b>Declaring variables</b>
	 * <ul>
	 * <li>if you declare same type in one line they must share same type
	 * declarations</li>
	 * </ul>
	 */

	// double d = 0,String e; Compiler Error because they must same type and share
	// same type declarations
	// double d, double d1; they have same type but not sharing a same declarations
	// its a compiler error
	double d, d1; // legal

}

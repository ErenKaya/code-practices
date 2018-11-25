package kim.eren.oca_8_certificate.oca_study_guide.chapter2;

/**
 * <p>
 * Now that you understand the basics of arithmetic operators, it is vital we
 * talk about primi- tive numeric promotion, as Java may do things that seem
 * unusual to you at fi rst. If you recall in Chapter 1, “Java Building Blocks,”
 * where we listed the primitive numeric types, each primitive has a bit-length.
 * You don’t need to know the exact size of these types for the exam, but you
 * should know which are bigger than others. For example, you should know that a
 * long takes up more space than an int , which in turn takes up more space than
 * a short , and so on. You should memorize certain rules Java will follow when
 * applying operators to data types:
 * </p>
 * 
 * @author eren
 *
 */
public class NumericPromotion {

	public static void main(String[] args) {
		/**
		 * <h2>RULE 1</h2>
		 * <p>
		 * If two values have different data types, Java will automatically promote one
		 * of the val- ues to the larger of the two data types.
		 * </p>
		 */
		int val1 = 5;
		long val2 = 55;
		Object val3 = val1 * val2;
		/**
		 * this result showing us that value will promote to long
		 */
		System.out.println(val3 instanceof Long); // result true

		/**
		 * <h2>RULE 2</h2>
		 * <p>
		 * If one of the values is integral and the other is floating-point, Java will
		 * automatically promote the integral value to the floating-point value’s data
		 * type.
		 * </p>
		 */
		int val4 = 5;
		float val5 = 55.2f;
		Object val6 = val4 * val5;
		/**
		 * this result showing us that value will promote to long
		 */
		System.out.println(val6 instanceof Float); // result true
		/**
		 * <h2>RULE 3</h2>
		 * <p>
		 * Smaller data types, namely byte , short , and char , are first promoted to
		 * int any time they’re used with a Java binary arithmetic operator, even if
		 * neither of the operands is int .
		 * </p>
		 */
		short val7 = 5;
		byte val8 = 12;
		Object val9 = val7 * val8;
		/**
		 * this result showing us that value will promote to long
		 */
		System.out.println(val9 instanceof Integer); // result true

		/**
		 * <h2>RULE 4</h2>
		 * <p>
		 * After all promotion has occurred and the operands have the same data type,
		 * the result- ing value will have the same data type as its promoted operands.
		 * </p>
		 */
		short val10 = 5;
		int val11 = 12;
		float val12 = 3.0f;
		double val14 = 4.0f;
		Object val13 = val12 * val11 / val10 * val14;
		/**
		 * this result showing us that value will promote to long
		 */
		System.out.println(val13 instanceof Double); // result true
	}

}

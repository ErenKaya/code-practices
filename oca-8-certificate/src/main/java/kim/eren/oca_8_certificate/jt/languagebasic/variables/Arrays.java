package kim.eren.oca_8_certificate.jt.languagebasic.variables;

/**
 * <ul>
 * <li>Searching an array for a specific value to get the index at which it is
 * placed (the <code>binarySearch</code> method).</li>
 * <li>Comparing two arrays to determine if they are equal or not (the
 * <code>equals</code> method).</li>
 * <li>Filling an array to place a specific value at each index (the
 * <code>fill</code> method).</li>
 * <li>Sorting an array into ascending order. This can be done either
 * sequentially, using the <code>sort</code> method, or concurrently, using the
 * <code>parallelSort</code> method introduced in Java SE 8. Parallel sorting of
 * large arrays on multiprocessor systems is faster than sequential array
 * sorting.</li>
 * </ul>
 * 
 * @author eren
 *
 */
public class Arrays extends Variables {
	// Alternatively, you can use the shortcut syntax to create and initialize an
	// array:
	int[] anArray = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

	public static void main(String[] args) {
		/**
		 * System object has a method which is makes clone from your source array.
		 */
		// System.arraycopy(src, srcPos, dest, destPos, length);

		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };

		char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

		System.out.println(new String(copyTo));
		java.lang.System.out.println("asd");
	
	}

}

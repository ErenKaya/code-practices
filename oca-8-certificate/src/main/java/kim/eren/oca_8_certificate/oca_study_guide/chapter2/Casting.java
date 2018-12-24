package kim.eren.oca_8_certificate.oca_study_guide.chapter2;

public class Casting {

	short x = 10;
	short y = 3;
	// short z = x * y; // DOES NOT COMPILE
	/**
	 * that line of 6 doesn't compile why ? because if you multiplicate two smaller
	 * type that types promote to int so that result type will be int but we are
	 * declare as a short we should cast to smaller data
	 */
	short z = (short) (x * y);
	/**
	 * that line doesn't compile
	 */
	// String message = 10>10? "Greater then x":false;

	long yT = 4;
	/**
	 * that line also doesn't compile because yT was long so declared value have to
	 * be long!
	 */
	// int xT = 5 * yT;

	byte yB = 50, xB = 40;
	/**
	 * that line doesn't compile
	 */
	// byte resB = (byte) yB + xB;

}

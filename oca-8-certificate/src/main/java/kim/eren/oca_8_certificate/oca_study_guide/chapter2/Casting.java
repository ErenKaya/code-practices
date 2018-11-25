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

}

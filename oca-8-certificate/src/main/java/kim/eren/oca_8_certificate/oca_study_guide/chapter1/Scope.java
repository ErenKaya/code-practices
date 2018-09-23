package kim.eren.oca_8_certificate.oca_study_guide.chapter1;

public class Scope {
	static int MAX_LENGTH = 5;
	/**
	 * if the global primitive variables not initiliaze default value is 0
	 */
	int length;

	public void grow(int inches) {
		if (length < MAX_LENGTH) {
			int newSize = length + inches;
			length = newSize;
		}

	}

	/**
	 * if the global primitive variables not initiliaze default value is 0
	 */
	static int i;

	public static void main(String[] args) {
		Scope scope = new Scope();
		scope.grow(5);
		for (; i < 10; i++) {
			System.out.println("denedik");
		}
	}

}

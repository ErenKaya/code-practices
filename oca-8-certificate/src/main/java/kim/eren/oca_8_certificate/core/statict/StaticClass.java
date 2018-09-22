package kim.eren.oca_8_certificate.core.statict;

public class StaticClass {

	/*
	 * This practice doesn't contain any impl code so you should look out test packages with same name
	 * StaticTest.java class
	 */
	
	{
		System.out.println("Instance Block -1");
	}

	{
		System.out.println("Instance Block -2");
	}

	static {
		System.out.println("static Block -1");
	}

	static {
		System.out.println("static Block -2");
	}

	public StaticClass() {
		super();
		System.out.printf("constructor arg-0");
	}

	public StaticClass(int number) {
		super();
		System.out.printf("constructor with arg-1 %d \n", number);
	}

}

package kim.eren.oca_8_certificate.oca_study_guide.chapter1;

public class Chick {

	// Correct Constructor!
	/**
	 * <b>Constructors</b>
	 * <ul>
	 * <li>Constructor method has not a return type.</li>
	 * <li>public void Chick() not a constructor.</li>
	 * <li>if class has not a constructor declaration compiler supply "constructor
	 * will do nothing"</li>
	 * </ul>
	 * 
	 */
	public Chick() {
	}

	// Not Correct Constructor!
	// public void Chick() {
	// }

	private String name = "Eren";
	// Instance block test
	/**
	 * Instance created and that block executed.
	 * instance block should be below declaration
	 */
	{
		System.out.println(name);
	}

	public static void main(String[] args) {
		Chick chick = new Chick();
		chick.name = "Kaya";
		System.out.println(chick.name);
	}

}

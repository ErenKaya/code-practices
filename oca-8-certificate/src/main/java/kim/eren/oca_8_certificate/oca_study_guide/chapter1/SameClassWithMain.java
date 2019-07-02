package kim.eren.oca_8_certificate.oca_study_guide.chapter1;

public class SameClassWithMain {
	private String strTest;
	private boolean boolTest;
	

	public static void main(String[] args) {
		SameClassWithMain scwm = new SameClassWithMain();
		ProductScwm pScwm = new ProductScwm();
		System.err.println(scwm.strTest + String.valueOf(scwm.boolTest));
	}
}

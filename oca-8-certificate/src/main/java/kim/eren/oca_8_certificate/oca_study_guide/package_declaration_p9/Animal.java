package kim.eren.oca_8_certificate.oca_study_guide.package_declaration_p9;

// Ubuntu textfile
import java.util.Random;

public class Animal {

	public static void main(String[] args) {
		Random r = new Random(); // COMPILE ERROR
		System.out.println(r.nextInt(10));
	}

}

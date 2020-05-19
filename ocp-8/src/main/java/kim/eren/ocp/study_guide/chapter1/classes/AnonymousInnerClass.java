package kim.eren.ocp.study_guide.chapter1.classes;

/**
 * this type of declaration of class same with local inner class but that type
 * has no name
 * 
 * @author erenk
 *
 */
public class AnonymousInnerClass {

	abstract class SaleTodayOnly {
		abstract int dolarsOff();
	}

	public int admission(int basePrice) {
		SaleTodayOnly sToday = new SaleTodayOnly() {

			@Override
			int dolarsOff() {
				return 3;
			}
		};
		return sToday.dolarsOff() + basePrice;
	}

	public static void main(String[] args) {
		test_anonymous_inner_class();
	}

	private static void test_anonymous_inner_class() {
		AnonymousInnerClass test = new AnonymousInnerClass();
		System.out.println(test.admission(40));
	}
}

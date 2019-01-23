package kim.eren.oca_8_certificate.oca_study_guide.chapter3.string_methods;

public class TestString {
	class EqualityA{
		String a;
	}
	
	public static void main(String[] args) {
		String object1 = new String("Object");
		String object2 = new String("Object");
		System.out.println(object1.equals(object2));
		EqualityA a1 = new TestString().new EqualityA();
		EqualityA a2 = new TestString().new EqualityA();
		System.out.println(a1.equals(a2));
	}

}

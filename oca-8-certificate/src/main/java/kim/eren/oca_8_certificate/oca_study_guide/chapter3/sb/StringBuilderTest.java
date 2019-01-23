package kim.eren.oca_8_certificate.oca_study_guide.chapter3.sb;

public class StringBuilderTest {
	public static void main(String[] args) {
		/*
		 * Did you say both print "abcdefg" ? Good. There’s only one StringBuilder
		 * object here. We know that because new StringBuilder() was called only once.
		 * On line 5, there are two variables referring to that object, which has a
		 * value of "abcde" . On line 6, those two variables are still referring to that
		 * same object, which now has a value of "abcdefg" . Incidentally, the
		 * assignment back to b does absolutely nothing. b is already pointing to that
		 * StringBuilder .
		 */

		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de");
		b = b.append("f").append("g");
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		/**
		 * Notice that substring() returns a String rather than a StringBuilder . That
		 * is why sb is not changed. substring() is really just a method that inquires
		 * about where the substring happens to be.
		 */

		StringBuilder sb = new StringBuilder("animals");
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
		int len = sb.length();
		char ch = sb.charAt(6);
		System.out.println(sub + " " + len + " " + ch); // anim 7 s

		StringBuilder sb2 = new StringBuilder("abcdef");
		sb2.delete(1, 3);
		System.out.println(sb2);
		// sb = adef
//		sb2.deleteCharAt(5);
		// throws an exception
	}
}

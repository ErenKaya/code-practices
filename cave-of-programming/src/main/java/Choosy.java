
import java.util.HashMap;
import java.util.Map;

public class Choosy {

	public static void main(String[] args) {
		String result = "";
		int x = 7, y = 8;
		if (x == 3) {
			result += "1";
		} else if (x > 9) {
			result += "2";
		} else if (y < 9) {
			result += "3";
		} else if (x == 7) {
			result += "4";
		} else {
			result += "5";
		}
		System.out.println(result);
	}

}

class Twine {
	public static void main(String[] args) {
		String s = "";
		StringBuilder sb = new StringBuilder("Hi");
		StringBuilder sb2 = new StringBuilder("Hi");
		StringBuilder sb3 = new StringBuilder(sb2);
		StringBuilder sb4 = sb3;

	}
}

class BirthDays {
	public static void main(String[] args) {
		Map<Friend, String> hm = new HashMap<Friend, String>();
		hm.put(new Friend("Charis"), "Summer 2009");
		hm.put(new Friend("Draumur"), "Spring 2002");
		Friend f = new Friend(args[0]);
		System.out.println(hm.get(f));
	}
}

class Friend {
	String name;

	public Friend(String n) {
		name = n;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Friend))
			return false;
		if (obj == this)
			return true;
		return this.name == ((Friend) obj).name;
	}

}
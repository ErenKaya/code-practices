package kim.eren.ocp.study_guide.chapter3;

import java.util.NavigableSet;
import java.util.TreeSet;

public class JCollectionTest {

	public static void main(String[] args) {
		NavigableSet<Integer> nIntegers = new TreeSet<>();
		for (int i = 0; i <= 20; i++)
			nIntegers.add(i);

		System.out.println(nIntegers.ceiling(20)); // outputs 20 that method returns greater and equals
		System.out.println(nIntegers.higher(20)); // output null that method returns greates in a list from it if not
													// exist it returns null!
		System.out.println(nIntegers.floor(10)); // return greatest from parameter also equals
		System.out.println(nIntegers.lower(10)); // return greatest from parameter
	}

}

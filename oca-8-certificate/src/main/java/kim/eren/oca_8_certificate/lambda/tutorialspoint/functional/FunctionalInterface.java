package kim.eren.oca_8_certificate.lambda.tutorialspoint.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterface {

	public List list;


	public List<Integer> eval(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> resultList = new ArrayList<>();
		for (Integer n : list) {
			if (predicate.test(n)) {
				resultList.add(n);
			}
		}
		return resultList;
	}

}

package kim.eren.ocp.study_guide.chapter3.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kim.eren.ocp.study_guide.chapter3.compare.Duck;

public class MethodRef {

	public static class MethodRefHelper {
		public static int compareByWeight(Duck d1, Duck d2) {
			return d1.getWeight() - d2.getWeight();
		}

		public static int compareById(Duck d1, Duck d2) {
			return d1.getId() - d2.getId();
		}
	}

	/**
	 * that :: syntax used for pass parameters to another method because of if it
	 * not pass you have to pass like this (d1,d2) ->
	 * MethodHelper.compareByWeight(d1,d2);
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Duck> sortByWeight = MethodRefHelper::compareByWeight;
		Comparator<Duck> sortByWeightOld = (d1, d2) -> MethodRefHelper.compareByWeight(d1, d2);
		List<Duck> ducks = new ArrayList<Duck>();
		ducks.add(new Duck(1, 100));
		ducks.add(new Duck(3, 300));
		ducks.add(new Duck(23, 2300));
		ducks.add(new Duck(12, 1200));
		ducks.add(new Duck(-5, 500));
		Collections.sort(ducks, sortByWeight);
		for (Duck d : ducks) {
			System.out.println(d.getWeight() + " id: " + d.getId());
		}
	}

}

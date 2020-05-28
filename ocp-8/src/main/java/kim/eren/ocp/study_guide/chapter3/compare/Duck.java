package kim.eren.ocp.study_guide.chapter3.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Duck implements Comparable<Duck> {
	private int id;
	private int weight;

	public Duck(int id, int weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Duck o) {
		return this.id - o.id;
	}

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck(1, 100));
		ducks.add(new Duck(3, 300));
		ducks.add(new Duck(23, 2300));
		ducks.add(new Duck(12, 1200));
		ducks.add(new Duck(-5, 500));
		Collections.sort(ducks);
		for (Duck d : ducks) {
			System.out.println(d.getId());
		}
		System.out.println("**** compare by weight **** ");
		Comparator<Duck> byWeight = new Comparator<Duck>() {

			@Override
			public int compare(Duck o1, Duck o2) {
				return o1.weight - o2.weight;
			}
		};

		Collections.sort(ducks, byWeight);
		for (Duck d : ducks) {
			System.out.println(d.getWeight() + " id: " + d.getId());
		}
	}

}

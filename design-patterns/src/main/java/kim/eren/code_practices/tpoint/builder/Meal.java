package kim.eren.code_practices.tpoint.builder;

import java.util.ArrayList;
import java.util.List;

import kim.eren.code_practices.tpoint.builder.interfaces.Item;

public class Meal {
	private List<Item> mealList;

	public Meal() {

		this.mealList = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		mealList.add(item);
	}

	public float getCost() {
		float cost = 0.0f;

		for (Item item : mealList) {
			cost += item.price();
		}
		return cost;
	}

	public void showItems() {
		for (Item item : mealList) {
			System.out.print("Item : " + item.name());
			System.out.print(", Packing : " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}
	}

	

}

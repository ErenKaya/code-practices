package kim.eren.code_practices.builder;

import kim.eren.code_practices.builder.entities.ChickenBurger;
import kim.eren.code_practices.builder.entities.Coke;
import kim.eren.code_practices.builder.entities.Pepsi;
import kim.eren.code_practices.builder.entities.VegBurger;

public class MealBuilder {
	
	public Meal prepareVegBurger() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
	
	public Meal prepareChickenBurger() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Coke());
		return meal;
	}

}

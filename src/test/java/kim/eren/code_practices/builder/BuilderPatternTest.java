package kim.eren.code_practices.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BuilderPatternTest {
	
	private MealBuilder mealBuilder;
	
	@Before
	public void init() {
		mealBuilder = new MealBuilder();
	}
	
	@Test
	public void vegburger_show_items_test() {
		Meal meal = mealBuilder.prepareVegBurger();
		meal.showItems();
		System.out.println("Total Cost : "+meal.getCost());
	}
	
	@Test
	public void chicken_burger_show_items_test() {
		Meal meal = mealBuilder.prepareChickenBurger();
		meal.showItems();
		System.out.println("Total Cost : "+meal.getCost());
	}

}

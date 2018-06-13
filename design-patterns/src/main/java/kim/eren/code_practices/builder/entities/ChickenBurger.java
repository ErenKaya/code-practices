package kim.eren.code_practices.builder.entities;

import kim.eren.code_practices.builder.entities.abstracts.Burger;

public class ChickenBurger extends Burger{

	public String name() {
		return "ChickenBuger";
	}

	@Override
	public float price() {
		return 20.5f;
	}

}

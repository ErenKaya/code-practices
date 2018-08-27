package kim.eren.code_practices.tpoint.builder.entities;

import kim.eren.code_practices.tpoint.builder.entities.abstracts.Burger;

public class VegBurger extends Burger{

	public String name() {
		return "VegBurger";
	}

	@Override
	public float price() {
		return 12.5f;
	}

}

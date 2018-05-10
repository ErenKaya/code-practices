package kim.eren.code_practices.builder.entities;

import kim.eren.code_practices.builder.entities.abstracts.ColdDrink;

public class Coke extends ColdDrink {

	public String name() {
		return "Coke";
	}

	@Override
	public float price() {
		return 0.75f;
	}

}

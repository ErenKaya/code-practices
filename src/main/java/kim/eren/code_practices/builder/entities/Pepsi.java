package kim.eren.code_practices.builder.entities;

import kim.eren.code_practices.builder.entities.abstracts.ColdDrink;

public class Pepsi extends ColdDrink {

	public String name() {
		return "pepsi";
	}

	@Override
	public float price() {
		return 0.5f;
	}

}

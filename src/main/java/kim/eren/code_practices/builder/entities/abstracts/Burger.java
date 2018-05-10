package kim.eren.code_practices.builder.entities.abstracts;

import kim.eren.code_practices.builder.entities.packing.Wrapper;
import kim.eren.code_practices.builder.interfaces.Item;
import kim.eren.code_practices.builder.interfaces.Packaging;

public abstract class Burger implements Item {

	public Packaging packing() {
		return new Wrapper();
	}

	public abstract float price();

}

package kim.eren.code_practices.tpoint.builder.entities.abstracts;

import kim.eren.code_practices.tpoint.builder.entities.packing.Bottle;
import kim.eren.code_practices.tpoint.builder.interfaces.Item;
import kim.eren.code_practices.tpoint.builder.interfaces.Packaging;

public abstract class ColdDrink implements Item {

	public Packaging packing() {
		return new Bottle();
	}

	public abstract float price();

}

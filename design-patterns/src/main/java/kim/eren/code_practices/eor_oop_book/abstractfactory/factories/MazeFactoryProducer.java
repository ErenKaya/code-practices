package kim.eren.code_practices.eor_oop_book.abstractfactory.factories;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.enums.FactoryType;

public class MazeFactoryProducer {
	public static AbsMazeFactory getFactory(String factoryType) {
		if (factoryType != null) {
			if (FactoryType.ENCHANTED.toString().equals(factoryType)) {
				return new EnchantedMazeFactory();
			} else if (FactoryType.ENCHANTED.toString().equals(factoryType)) {
				return new MazeFactory();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}

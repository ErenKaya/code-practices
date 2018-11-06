package kim.eren.code_practices.eor_oop_book.creational.abstractfactory.factories;

import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.creational.abstractfactory.enums.FactoryType;

public class MazeFactoryProducer {
	public static AbsMazeFactory getFactory(String factoryType) {
		if (factoryType != null) {
			if (FactoryType.ENCHANTED.toString().equals(factoryType)) {
				return new EnchantedMazeFactory();
			} else if (FactoryType.NORMAL.toString().equals(factoryType)) {
				return new MazeFactory();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}

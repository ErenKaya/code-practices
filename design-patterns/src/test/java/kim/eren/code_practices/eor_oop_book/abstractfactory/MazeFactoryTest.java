package kim.eren.code_practices.eor_oop_book.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.eor_oop_book.abstractfactory.abstracts.AbsMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.enums.FactoryType;
import kim.eren.code_practices.eor_oop_book.abstractfactory.factories.EnchantedMazeFactory;
import kim.eren.code_practices.eor_oop_book.abstractfactory.factories.MazeFactoryProducer;

public class MazeFactoryTest {

	AbsMazeFactory factory;
	MazeFactoryProducer factoryProducer;

	@Before
	public void init() {
		factoryProducer = new MazeFactoryProducer();
	}

	@Test
	public void abstract_factory_pattern_enchanted_factory_test() {
		factory = factoryProducer.getFactory(FactoryType.ENCHANTED.toString());
		assertEquals(FactoryType.ENCHANTED.toString(), getFactoryResult(factory));
	}

	private String getFactoryResult(AbsMazeFactory resultFromFactory) {
		if (resultFromFactory instanceof EnchantedMazeFactory) {
			return FactoryType.ENCHANTED.toString();
		} else {
			return null;
		}
	}

}

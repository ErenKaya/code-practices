package kim.eren.code_practices.tpoint.abstractfactories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.abstractfactories.AbstractFactory;
import kim.eren.code_practices.tpoint.abstractfactories.FactoryProducer;
import kim.eren.code_practices.tpoint.abstractfactories.enums.FactoryType;
import kim.eren.code_practices.tpoint.factorypattern.ShapeFactory;

public class AbstractFactoryTest {

	AbstractFactory factory;
	FactoryProducer factoryProducer;

	@Before
	public void init() {
		factoryProducer = new FactoryProducer();
	}

	@Test
	public void abstract_factory_pattern_shape_factory_test() {
		factory = factoryProducer.getFactory(FactoryType.SHAPE.toString());
		assertEquals("shape", getFactoryResult(factory));
	}

	@Test
	public void abstract_factory_pattern_null_check() {
		factory = factoryProducer.getFactory("");
		assertEquals(null, getFactoryResult(factory));
	}
	
	@Test
	public void abstract_factory_pattern_is_method_checks_nullable() {
		factory = factoryProducer.getFactory(null);
		assertEquals(null, getFactoryResult(factory));
	}

	private String getFactoryResult(AbstractFactory resultFromFactory) {
		if (resultFromFactory instanceof ShapeFactory) {
			return "shape";
		} else {
			return null;
		}
	}

}

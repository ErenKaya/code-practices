package kim.eren.oca_8_certificate.core.absint;

import java.util.Collection;

import org.junit.Before;

public class TestAbstractInterface extends TestInterfaceMethod implements TestInterface {
	AbsFood cheetos;
	Collection<String> collection;

	@Before
	public void init() {
		cheetos = new Cheetos();
		((Cheetos) cheetos).diffrentMethod();
	}

	public void foodType(AbsFood food) {
		System.err.println("foodType executed");
	}
}

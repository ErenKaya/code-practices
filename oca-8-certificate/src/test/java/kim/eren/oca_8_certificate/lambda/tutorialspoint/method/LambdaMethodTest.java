package kim.eren.oca_8_certificate.lambda.tutorialspoint.method;

import org.junit.Before;
import org.junit.Test;

public class LambdaMethodTest {
	
	LambdaMethod methodIns;
	
	@Before
	public void init() {
		methodIns = new LambdaMethod();
		methodIns.names.add("Eren");
		methodIns.names.add("İbrahim");
		methodIns.names.add("Muzo");
		methodIns.names.add("Aydın");
		methodIns.names.add("Eren");
	}
	
	
	@Test
	public void test_lambda_method() {
		methodIns.names.forEach(System.out::println);
	}

}

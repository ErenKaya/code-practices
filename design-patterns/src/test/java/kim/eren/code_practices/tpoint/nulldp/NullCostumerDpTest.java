package kim.eren.code_practices.tpoint.nulldp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NullCostumerDpTest {

	private static String[] customerArray = { "Hayrullah", "Eren", "Serkan", "İbrahim", "Mert" };
	private CustomerRepo repo;

	@Before
	public void init() {
		repo = new CustomerRepo(customerArray);
	}

	@Test
	public void test_not_existing_name_null_check() {
		AbstractCustomer customer = repo.getCustomer("Uğur");
		assertNotNull(customer);
	}

	@Test
	public void test_object_is_nill() {
		AbstractCustomer customer = repo.getCustomer("Uğur");
		assertTrue(customer.isNill());
	}

	@Test
	public void test_object_is_real_customer() {
		AbstractCustomer customer = repo.getCustomer("Hayrullah");
		assertFalse(customer.isNill());
	}
}

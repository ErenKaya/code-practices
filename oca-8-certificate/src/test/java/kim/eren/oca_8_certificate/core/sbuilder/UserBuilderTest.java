package kim.eren.oca_8_certificate.core.sbuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserBuilderTest {

	@Test
	public void test_user_builder_create() {
		User user = UserBuilder.anUser()
				.age(20)
				.name("Eren")
				.surname("Kaya")
				.build();
		assertEquals("Eren",user.getName());
	}

}

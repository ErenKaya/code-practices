package kim.eren.oca_8_certificate.lambda.mmullerbook.chapter_6;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	/**
	 * I should test another case i didn't understand what do you mean with optional object.
	 */
	public void test_optional_string() {
		String number = null;
		OptionalExample optionalExample = new OptionalExample();
		optionalExample.strExample = Optional.ofNullable(number);
		boolean optionalResultIsNull = true;
		if(optionalExample.strExample.isPresent()) {
			optionalResultIsNull = false;
		}
		
		assertTrue(optionalResultIsNull);

	}
}

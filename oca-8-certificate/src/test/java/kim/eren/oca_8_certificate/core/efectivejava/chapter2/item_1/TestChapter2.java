package kim.eren.oca_8_certificate.core.efectivejava.chapter2.item_1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kim.eren.oca_8_certificate.core.efectivejava.chapter_2.item_1.Chapter2Util;

public class TestChapter2 {

	@Test
	public void test_boolean_valueOf() {
		assertFalse(Chapter2Util.valueOf(false));
		assertTrue(Chapter2Util.valueOf(true));	
	}
	
	/**
	 * Static factory method explains what it do in names 
	 * BigInteger(int,int,Random) that example of constructor return probably BigInteger
	 * but as you can see developer doesn't know that class referee what? so easialy you can make
	 * a static method which name is BigInteger.probablyPrime()
	 */
}

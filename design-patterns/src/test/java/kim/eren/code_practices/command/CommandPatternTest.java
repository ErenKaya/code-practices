package kim.eren.code_practices.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommandPatternTest {
	
	private Commander commander;
	
	@Before
	public void init() {
		commander = new Commander();
	}
	
	@Test
	public void television_open_test() {
		assertEquals(commander.tusla(1).getCode(), "1");
	}
	
	
	@Test
	public void television_close_test() {
		assertEquals(commander.tusla(0).getCode(), "0");
	}

}

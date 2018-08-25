package kim.eren.code_practices.tpoint.cordp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kim.eren.code_practices.tpoint.CodePracticeResult;
import kim.eren.code_practices.tpoint.cordp.AbstractLogger;
import kim.eren.code_practices.tpoint.cordp.ConsoleLogger;
import kim.eren.code_practices.tpoint.cordp.ErrorLogger;
import kim.eren.code_practices.tpoint.cordp.FileLogger;

public class CorDesignPatternTest {
	private AbstractLogger errorLogger;

	@Before
	public void init() {
		errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
	}

	@Test
	public void test_log_info_from_chain() {
		AbstractLogger loggerChain = errorLogger;
		CodePracticeResult result = loggerChain.logMessage(AbstractLogger.INFO, "INFO");
		assertEquals("1", result.getResultId());
		System.out.println(result.getResultText());

	}

	@Test
	public void test_log_debug_from_chain() {
		AbstractLogger loggerChain = errorLogger;
		CodePracticeResult result = loggerChain.logMessage(AbstractLogger.DEBUG, "DEBUG");
		assertEquals("2", result.getResultId());
		System.out.println(result.getResultText());
	}

	@Test
	public void test_log_error_from_chain() {
		AbstractLogger loggerChain = errorLogger;
		CodePracticeResult result = loggerChain.logMessage(AbstractLogger.ERROR, "ERROR");
		assertEquals("3", result.getResultId());
		System.out.println(result.getResultText());
	}

}

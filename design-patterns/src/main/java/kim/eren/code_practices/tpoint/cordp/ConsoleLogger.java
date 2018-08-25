package kim.eren.code_practices.tpoint.cordp;

import kim.eren.code_practices.tpoint.CodePracticeResult;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		super.logLevel = level;
	}

	@Override
	protected CodePracticeResult write(String message) {
		return new CodePracticeResult("1", "Standard Console::Logger: " + message);
	}

}

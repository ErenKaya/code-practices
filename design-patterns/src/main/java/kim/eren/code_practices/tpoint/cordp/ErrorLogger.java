package kim.eren.code_practices.tpoint.cordp;

import kim.eren.code_practices.CodePracticeResult;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		super.logLevel = level;
	}

	@Override
	protected CodePracticeResult write(String message) {
		return new CodePracticeResult("3", "Error Console::Logger: " + message);
	}

}

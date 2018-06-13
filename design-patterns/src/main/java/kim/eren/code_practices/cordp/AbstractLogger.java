package kim.eren.code_practices.cordp;

import kim.eren.code_practices.CodePracticeResult;

public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	protected int logLevel;

	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public CodePracticeResult logMessage(int level, String message) {
		if (this.logLevel <= level) {
			return write(message);
		}
		if (nextLogger != null) {
			return nextLogger.logMessage(level, message);
		}
		return null;
	}

	abstract protected CodePracticeResult write(String message);

}

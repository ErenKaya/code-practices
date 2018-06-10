package kim.eren.code_practices.cordp;

import kim.eren.code_practices.CodePracticeResult;

public class FileLogger extends AbstractLogger {
	
	

	public FileLogger(int level) {
		super.logLevel = level;
	}

	@Override
	protected CodePracticeResult write(String message) {
		return new CodePracticeResult("2","File::Logger: " + message);
	}

}

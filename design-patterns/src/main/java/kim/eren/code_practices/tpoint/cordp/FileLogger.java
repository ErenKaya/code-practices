package kim.eren.code_practices.tpoint.cordp;

import kim.eren.code_practices.tpoint.CodePracticeResult;

public class FileLogger extends AbstractLogger {
	
	

	public FileLogger(int level) {
		super.logLevel = level;
	}

	@Override
	protected CodePracticeResult write(String message) {
		return new CodePracticeResult("2","File::Logger: " + message);
	}

}

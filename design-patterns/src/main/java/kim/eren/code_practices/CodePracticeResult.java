package kim.eren.code_practices;

import org.apache.log4j.Logger;

public class CodePracticeResult {
	final static Logger logger = Logger.getLogger(CodePracticeResult.class);

	private String resultId;
	private String resultText;

	public CodePracticeResult() {

	}

	public CodePracticeResult(String resultId, String resultText) {
		super();
		this.resultId = resultId;
		this.resultText = resultText;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getResultText() {
		logger.debug("This is debug : " + resultText);
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

}

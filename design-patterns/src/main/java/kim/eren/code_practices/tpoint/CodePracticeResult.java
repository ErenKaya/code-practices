package kim.eren.code_practices.tpoint;

public class CodePracticeResult {

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
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

}

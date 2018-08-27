package kim.eren.code_practices.tpoint.interpreterdp;

public class TerminalExpression implements Expression {

	public String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	public boolean interpret(String context) {
		if (context.contains(data)) {
			return true;
		} else {
			return false;
		}
	}

}

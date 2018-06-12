package kim.eren.code_practices.interpreterdp;

public class AndExpression implements Expression {

	private Expression exp1 = null;
	private Expression exp2 = null;

	public AndExpression(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public boolean interpret(String context) {

		return exp1.interpret(context) && exp2.interpret(context);
	}

}

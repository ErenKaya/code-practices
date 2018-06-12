package kim.eren.code_practices.interpreterdp;

public class OrExpression implements Expression {

	private Expression exp1;
	private Expression exp2;

	/**
	 * Neighter exp1 nor exp2 cannot null! 
	 * @param exp1
	 * @param exp2
	 */
	public OrExpression(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public boolean interpret(String context) {
		return exp1.interpret(context) || exp2.interpret(context);
	}

}

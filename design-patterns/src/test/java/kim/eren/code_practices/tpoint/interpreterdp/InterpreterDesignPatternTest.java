package kim.eren.code_practices.tpoint.interpreterdp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kim.eren.code_practices.tpoint.interpreterdp.AndExpression;
import kim.eren.code_practices.tpoint.interpreterdp.Expression;
import kim.eren.code_practices.tpoint.interpreterdp.OrExpression;
import kim.eren.code_practices.tpoint.interpreterdp.TerminalExpression;

public class InterpreterDesignPatternTest {
	
	
	@Test
	public void test_maried_women() {
		Expression juliaMaritalStatus = getMarriedWomenExp();
		assertEquals(true, juliaMaritalStatus.interpret("Julia Married"));
	}
	
	@Test
	public void test_and_expression_with_empty() {
		Expression juliaMaritalStatus = getMarriedWomenExp();
		assertEquals(false, juliaMaritalStatus.interpret(""));
	}
	@Test
	public void test_and_expression_null_keyword() {
		Expression juliaMaritalStatus = getMarriedWomenExp();
		try {
			juliaMaritalStatus.interpret(null);
		} catch (Exception e) {
			String expString = "";
			if(e instanceof NullPointerException) {
				expString = "null";
			}
			assertEquals("null", expString);
		}
	}
	@Test
	public void test_male_expression() {
		Expression isMale = getMaleExpression();
		assertEquals(true, isMale.interpret("John"));
	}

	private Expression getMarriedWomenExp() {
		Expression julia = new TerminalExpression("Julia");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julia, married);
	}

	private Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

}

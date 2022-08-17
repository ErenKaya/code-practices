package io.erenkaya.akaldiroglu._05_example;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator implements CalculatorI {
	@Autowired
	@Qualifier("Sin")
	private MathFunction sin;
	@Autowired
	@Qualifier("Log")
	private MathFunction log;
	@Autowired
	@Qualifier("Cos")
	private MathFunction cos;

	@Autowired
	private Map<String, MathFunction> functionPair;

	@Autowired
	public void setFunctionPair(Map<String, MathFunction> functionPair) {
		this.functionPair = functionPair;
	}

	@Override
	public double doCalculation(String key, double value) {
		MathFunction function = this.functionPair.get(key);
		return function.calculate(value);
	}

}

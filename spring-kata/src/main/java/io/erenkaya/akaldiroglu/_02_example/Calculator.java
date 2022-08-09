package io.erenkaya.akaldiroglu._02_example;

import java.util.Map;

public class Calculator implements CalculatorI {

	private Map<String, MathFunction> functionPair;

	public void setFunctionPair(Map<String, MathFunction> functionPair) {
		this.functionPair = functionPair;
	}

	@Override
	public double doCalculation(String key, double value) {
		MathFunction function = this.functionPair.get(key);
		return function.calculate(value);
	}

}

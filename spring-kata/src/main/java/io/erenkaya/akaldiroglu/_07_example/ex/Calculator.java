package io.erenkaya.akaldiroglu._07_example.ex;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class Calculator implements CalculatorI {

	@Autowired
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

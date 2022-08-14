package io.erenkaya.akaldiroglu._07_example.ex;

public class Sin implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.sin(value);
	}

}

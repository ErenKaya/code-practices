package io.erenkaya.akaldiroglu._02_example;

public class Sin implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.sin(value);
	}

}

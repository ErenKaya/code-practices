package io.erenkaya.akaldiroglu._02_example;

public class Log implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.log(value);
	}

}

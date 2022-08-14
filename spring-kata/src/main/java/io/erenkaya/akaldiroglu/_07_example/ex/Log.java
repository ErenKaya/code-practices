package io.erenkaya.akaldiroglu._07_example.ex;

public class Log implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.log(value);
	}

}

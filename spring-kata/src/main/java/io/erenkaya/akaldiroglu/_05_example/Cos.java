package io.erenkaya.akaldiroglu._05_example;

import org.springframework.stereotype.Component;

@Component("cos")
public class Cos implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.cos(value);
	}

}

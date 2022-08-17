package io.erenkaya.akaldiroglu._05_example;

import org.springframework.stereotype.Component;

@Component("Sin")
public class Sin implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.sin(value);
	}

}

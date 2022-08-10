package io.erenkaya.akaldiroglu._05_example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sin")
@Qualifier("sin")
public class Sin implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.sin(value);
	}

}

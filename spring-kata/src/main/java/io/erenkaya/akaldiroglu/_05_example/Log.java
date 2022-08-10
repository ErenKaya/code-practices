package io.erenkaya.akaldiroglu._05_example;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("log")
@Qualifier("log")
public class Log implements MathFunction {

	@Override
	public double calculate(double value) {
		return Math.log(value);
	}

}

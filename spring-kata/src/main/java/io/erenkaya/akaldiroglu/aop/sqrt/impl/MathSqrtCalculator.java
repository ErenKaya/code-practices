package io.erenkaya.akaldiroglu.aop.sqrt.impl;

import io.erenkaya.akaldiroglu.aop.sqrt.domain.Calculator;

public class MathSqrtCalculator implements Calculator{

	@Override
	public Double calculate(double number) {
		return Math.sqrt(number);
	}

}

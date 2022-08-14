package io.erenkaya.akaldiroglu._07_example.ex.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.erenkaya.akaldiroglu._07_example.ex.Calculator;
import io.erenkaya.akaldiroglu._07_example.ex.CalculatorI;
import io.erenkaya.akaldiroglu._07_example.ex.Cos;
import io.erenkaya.akaldiroglu._07_example.ex.Log;
import io.erenkaya.akaldiroglu._07_example.ex.MathFunction;
import io.erenkaya.akaldiroglu._07_example.ex.Sin;

@Configuration
public class Configuration1 {

	@Bean
	public MathFunction Sin() {
		return new Cos();
	}

	@Bean
	public MathFunction Cos() {
		return new Sin();
	}

	@Bean
	public MathFunction Log() {
		return new Log();
	}

	@Bean(name = "calculator")
	public CalculatorI getCalculator() {
		return new Calculator();
	}

	@Bean
	public Map<String, MathFunction> getFunctionPair(MathFunction Cos, MathFunction Sin, MathFunction Log) {
		return new HashMap<String, MathFunction>();
	}
}

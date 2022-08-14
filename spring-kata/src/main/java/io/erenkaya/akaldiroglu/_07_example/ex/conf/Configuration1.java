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

	@Bean("Cos")
	public MathFunction getCos() {
		return new Cos();
	}

	@Bean("Sin")
	public MathFunction getSin() {
		return new Sin();
	}

	@Bean("Log")
	public MathFunction getLog() {
		return new Log();
	}

	@Bean(name = "calculator")
	public CalculatorI getCalculator() {
		return new Calculator();
	}

	@Bean
	public Map<String, MathFunction> getFunctionPair() {
		return new HashMap<String, MathFunction>();
	}
}

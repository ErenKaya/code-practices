package io.erenkaya.akaldiroglu._05_example;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator implements CalculatorI {
    @Autowired
    private MathFunction sin;
    @Autowired
    private MathFunction log;
    @Autowired
    private MathFunction cos;

    private Map<String, MathFunction> functionPair;

    @Autowired
    public void setFunctionPair(Map<String, MathFunction> functionPair) {
        this.functionPair = functionPair;
    }

    @Override
    public double doCalculation(String key, double value) {
        MathFunction function = this.functionPair.get(key);
        return function.calculate(value);
    }

    @PostConstruct
    public void init() {
        functionPair.put("Sin", sin);
        functionPair.put("Log", log);
        functionPair.put("Cos", cos);
    }

}

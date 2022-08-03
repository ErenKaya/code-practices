package io.erenkaya.akaldiroglu._01_example.domain;

public class StandartOutputProvider implements  GreetingProvider{

    private String greeting = "Hello World!";

    @Override
    public String getGreeting() {
        return greeting;
    }
}

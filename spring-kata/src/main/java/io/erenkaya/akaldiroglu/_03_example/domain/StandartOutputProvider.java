package io.erenkaya.akaldiroglu._03_example.domain;

public class StandartOutputProvider implements  GreetingProvider{

    private String greeting = "Hello World!";

    @Override
    public String getGreeting() {
        return greeting;
    }
}

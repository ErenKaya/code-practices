package io.erenkaya.akaldiroglu._03_example.domain;

public class ErrorOutputProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "There is an issue";
    }
}

package io.erenkaya.akaldiroglu._01_example.domain;

public class ErrorOutputProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "There is an issue";
    }
}

package io.erenkaya.akaldiroglu._03_example.domain;

public class ErrorOutputRenderer implements GreetingRenderer {

    private GreetingProvider provider;


    @Override
    public void setProvider(GreetingProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.err.println(this.provider.getGreeting());
    }
}

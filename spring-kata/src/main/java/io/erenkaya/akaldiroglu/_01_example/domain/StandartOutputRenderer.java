package io.erenkaya.akaldiroglu._01_example.domain;

public class StandartOutputRenderer implements GreetingRenderer {

    private GreetingProvider provider;

    @Override
    public void setProvider(GreetingProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        String message = this.provider.getGreeting();
        System.out.println(message);
    }
}
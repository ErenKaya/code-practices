package io.erenkaya.akaldiroglu._01_example;

import io.erenkaya.akaldiroglu._01_example.domain.StandartOutputProvider;
import io.erenkaya.akaldiroglu._01_example.domain.StandartOutputRenderer;

public class ApplicationXmlContainer {

    public static void main(String[] args) {
        StandartOutputProvider provider = new StandartOutputProvider();

        StandartOutputRenderer renderer = new StandartOutputRenderer();

        renderer.setProvider(provider);

        renderer.render();
    }
}

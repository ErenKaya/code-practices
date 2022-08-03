package io.erenkaya.akaldiroglu._01_example;

import io.erenkaya.akaldiroglu._01_example.domain.GreetingRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXmlContainer {



    public static void main(String[] args)  {
        String path = "bean.xml";
        ApplicationContext factory = new
                ClassPathXmlApplicationContext( path);
        GreetingRenderer renderer = (GreetingRenderer) factory.getBean("renderer");
        renderer.render();

        renderer = (GreetingRenderer) factory.getBean("renderer2");

        renderer.render();

    }
}

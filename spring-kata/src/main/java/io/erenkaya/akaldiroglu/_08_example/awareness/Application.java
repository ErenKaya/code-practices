package io.erenkaya.akaldiroglu._08_example.awareness;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

@ComponentScan
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        String[] beanDefNames = context.getBeanDefinitionNames();
        Stream.of(beanDefNames).forEach(System.out::println);
    }
}

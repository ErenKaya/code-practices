package io.erenkaya.akaldiroglu._08_example.exercise;

import io.erenkaya.akaldiroglu._08_example.exercise.domain.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        for(int i = 0; i<10 ; i++){
            context.getBean(BeanG.class);
            context.getBean(BeanH.class);
        }
        System.out.println();
        context.close();

    }
}

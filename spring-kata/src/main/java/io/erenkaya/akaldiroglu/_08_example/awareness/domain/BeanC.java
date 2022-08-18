package io.erenkaya.akaldiroglu._08_example.awareness.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements BeanNameAware, ApplicationContextAware {

    private String name;

    private ApplicationContext context;


    @Autowired
    public void setName(String name) {
        System.err.printf("C.setName (%s) \n", name);
        this.name = name;
    }


    @Override
    public void setBeanName(String s) {
        System.err.printf("Bean Awareness [C] setBeanName %s \n", s);
        this.name = s;
    }

    @Override
    public String toString() {
        return "Bean[C]{" +
                "name='" + name + '\'' +
                ", context=" + context +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        Environment env = this.context.getEnvironment();
        String name = env.getProperty("user.name");
        this.name = name;
        System.err.printf("user name is, %s \n", name);
    }
}

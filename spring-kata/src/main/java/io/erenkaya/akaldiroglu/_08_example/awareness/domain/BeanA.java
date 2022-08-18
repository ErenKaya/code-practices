package io.erenkaya.akaldiroglu._08_example.awareness.domain;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements BeanNameAware {
    private String name;

    @Autowired
    public void setName(String name) {
        System.err.printf("A.setName (%s) \n",name);
        this.name = name;
    }


    @Override
    public void setBeanName(String s) {
        System.err.printf("Bean Awareness A. setBeanName %s \n", s);
        this.name = s;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                '}';
    }
}

package io.erenkaya.akaldiroglu._08_example.awareness.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements BeanNameAware, BeanFactoryAware {

    private String name;

    private BeanFactory factory;


    @Autowired
    public void setName(String name) {
        System.err.printf("B.setName (%s) \n",name);
        this.name = name;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.err.printf("Bean Awareness [B] setBeanName %s \n", s);
        this.name = s;
    }

    @Override
    public String toString() {
        return "Bean[B]{" +
                "name='" + name + '\'' +
                ", factory=" + factory +
                '}';
    }
}

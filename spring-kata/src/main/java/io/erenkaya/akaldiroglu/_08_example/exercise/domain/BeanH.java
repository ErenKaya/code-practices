package io.erenkaya.akaldiroglu._08_example.exercise.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanH implements InitializingBean, DisposableBean {

    private String name;
    private static int count;
    private int no;


    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BeanH{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("BeanH will be destroy " + no);
        count--;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.no = ++count;
        System.err.println("BeanH properties will be set"  + no);
    }

}

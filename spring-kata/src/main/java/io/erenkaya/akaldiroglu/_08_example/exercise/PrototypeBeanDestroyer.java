package io.erenkaya.akaldiroglu._08_example.exercise;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class PrototypeBeanDestroyer implements BeanFactoryAware, DisposableBean, BeanPostProcessor {
    private BeanFactory factory;

    private List<Object> prototypeBeans = new LinkedList<>();


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (factory.isPrototype(beanName)) {
            synchronized (prototypeBeans) {
                this.prototypeBeans.add(bean);
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("Disposable begin!");
            synchronized (prototypeBeans) {
            for (Object o : prototypeBeans) {
                if (o instanceof DisposableBean) {
                    DisposableBean bean = (DisposableBean) o;
                    try {
                        System.err.println("bean will be destroy" +bean);
                        bean.destroy();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

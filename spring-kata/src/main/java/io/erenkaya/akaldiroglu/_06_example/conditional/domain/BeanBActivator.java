package io.erenkaya.akaldiroglu._06_example.conditional.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Retention(RetentionPolicy.CLASS)
@Target(value = { ElementType.TYPE, ElementType.FIELD })
public @interface BeanBActivator {

}

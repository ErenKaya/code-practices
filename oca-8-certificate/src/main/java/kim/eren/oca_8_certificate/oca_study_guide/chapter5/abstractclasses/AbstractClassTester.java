package kim.eren.oca_8_certificate.oca_study_guide.chapter5.abstractclasses;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import kim.eren.oca_8_certificate.oca_study_guide.chapter5.abstractclasses.Rose;

public class AbstractClassTester {


    //there is no default accessor from abstract class but in the interfaces 
    // you have to know some default accessors here
    public static void main(String[] args) {
        for(Method m : Rose.class.getDeclaredMethods()){
            System.out.println("Method Name: "+m.getName() + "\n"+"method accessor: "+
            Modifier.toString(m.getModifiers()));
        }
    }
}
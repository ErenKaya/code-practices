
package com.caveofprogramming.section2.lecture60.naturalorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest=new MainTest();
        List<Person> list=new ArrayList<>();
        SortedSet<Person> set=new TreeSet<>();
//        
//        mainTest.addElement(set);
//        mainTest.addElement(list);
//        
//        Collections.sort(list);
//        
//        mainTest.showElement(set);
//        System.out.println();
//        mainTest.showElement(list);
//        
        
        mainTest.addPersonElement(set);
        mainTest.addPersonElement(list);
        
        Collections.sort(list);
        
        mainTest.showPersonElement(set);
        System.out.println();
        mainTest.showPersonElement(list);
    }
    public void addElement(Collection<String> col){
        col.add("Joe");
        col.add("Julliet");
        col.add("Clare");
        col.add("Sue");
        col.add("Mike");
    }
     public void showElement(Collection<String> col){
         for(String element: col){
             System.out.println(element);
         }
    }
       public void addPersonElement(Collection<Person> col){
        col.add(new Person("Joe"));
        col.add(new Person("Julliet"));
        col.add(new Person("Clare"));
        col.add(new Person("Sue"));
        col.add(new Person("Mike"));
    }
     public void showPersonElement(Collection<Person> col){
         for(Person element: col){
             System.out.println(element);
         }
    }

}

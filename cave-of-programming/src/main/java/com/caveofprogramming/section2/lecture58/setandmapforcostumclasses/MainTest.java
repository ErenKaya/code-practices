package com.caveofprogramming.section2.lecture58.setandmapforcostumclasses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainTest {

    public static void main(String[] args) {
        Person person1 = new Person(0, "Bob");
        Person person2 = new Person(1, "Sue");
        Person person3 = new Person(2, "Emre");
        Person person4 = new Person(1, "Sue");
        
        Map<Person, Integer> map = new HashMap<>();
        
        map.put(person1, 1);
        map.put(person2, 2);
        map.put(person3, 3);
        map.put(person4, 4);
        
        for(Person person : map.keySet()){
            System.out.println(person + ": "+map.get(person));
        }
        
        Set<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        System.out.println(set);
    }

}

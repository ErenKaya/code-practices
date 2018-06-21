
package com.caveofprogramming.section.lecture45.theequalsmethod;


public class MainTest {
    public static void main(String[] args) {
        Person person = new Person(5, "Bob");
        Person person1 = new Person(5, "Bob");
        
        System.out.println(person.equals(person1));
        
        Double double1=7.2;
        Double double2=7.2;
        System.out.println(double1==double2); // sebebini bilemiyorum doublelerde ilginç bi durum söz konusu
        
        Integer value1=3;
        Integer value2=3;
        
        System.out.println(value1==value2);
        
        String value3="Hello";
        String value4="Helloasdasd".substring(0,5);
        
        System.out.println("value3==value4 \n"+ value3==value4);
        System.out.println("Vaule3.equals(value4) "+value3.equals(value4)); // çünkü nesne olarak kıyaslandığında aynı değeri taşıdığı görülür.
    }

}

package com.caveofprogramming.section.lecture18;

public class Lecture18Test {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Purcell");
        person.setAge(37);
        person.speak();
        person.sayHello();
        int leftYears = person.calculateRetirementAge();
        System.out.println("Age of Retirement is: " + leftYears);

    }

}

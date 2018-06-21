package com.caveofprogramming.section.lecture18;

import com.caveofprogramming.section.lecture17.*;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    void speak(){
        System.out.println("My name is: "+ firstName +" " + lastName+ " and my age is " + age);
    }
    void sayHello(){
        System.out.println("Hello again!");
    }
    int calculateRetirementAge(){
        int leftYears;
        leftYears=65-age;
        return leftYears;
    }

}

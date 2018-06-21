package com.caveofprogramming.section.lecture23;

public class MainTest {

    public static void main(String[] args) {
        Thing.description = "I am a Thing!";
        Thing.showInfo();
        System.out.println("Before Creating Object " + Thing.count);
        Thing thing1 = new Thing();
        Thing thing2 = new Thing();
        System.out.println("After Creating Object " + Thing.count);
        thing1.name = "Bob";
        thing2.name = "Dylan";

        thing1.showName();
        thing2.showName();
        System.out.println(Thing.LUCKY_NUMBER);
        System.out.println(Math.PI);

    }

}

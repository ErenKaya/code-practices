package com.caveofprogramming.section.lecture41.abstractclasses;

public class Car extends Machine {

    @Override
    public void start() {
        System.out.println("The car is starting.");
    }

    @Override
    public void doStuff() {
        System.out.println("Do stuff");
    }

    @Override
    public void shutDown() {
        System.out.println("The car will shut down");
    }

}

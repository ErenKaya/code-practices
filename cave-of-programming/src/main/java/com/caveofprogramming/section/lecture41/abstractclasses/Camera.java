package com.caveofprogramming.section.lecture41.abstractclasses;

public class Camera extends Machine {

    @Override
    public void start() {
        System.out.println("The camera is starting.");
    }

    @Override
    public void doStuff() {
        System.out.println("Do stuff");
    }

    @Override
    public void shutDown() {
        System.out.println("The camera will shut down");
    }

}

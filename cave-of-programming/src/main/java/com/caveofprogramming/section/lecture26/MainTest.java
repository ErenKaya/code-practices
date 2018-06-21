package com.caveofprogramming.section.lecture26;

public class MainTest {

    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.start();
        machine.stop();
        Car car=new Car();
        car.start();
        car.wipeWindForces();
        car.stop();
        car.showInfo();

    }
}

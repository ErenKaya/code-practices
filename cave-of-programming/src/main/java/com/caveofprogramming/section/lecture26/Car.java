
package com.caveofprogramming.section.lecture26;


public class Car extends Machine {

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
    public void wipeWindForces(){
        System.out.println("Wind Forces active now !");
    }
    @Override
    public void start() {
        System.out.println("Car started.");
    }
    public void showInfo(){
        System.out.println("Car name is: "+machineName);
    }

}

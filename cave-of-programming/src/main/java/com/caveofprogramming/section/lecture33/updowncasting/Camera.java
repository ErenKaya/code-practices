
package com.caveofprogramming.section.lecture33.updowncasting;


public class Camera extends Machine{

    @Override
    public void stop() {
        System.out.println("The camera stopped.");
    }

    @Override
    public void start() {
        System.out.println("The camera started.");
    }
    public void snap(){
        System.out.println("Photo taken");
    }

}

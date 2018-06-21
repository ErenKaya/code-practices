
package com.caveofprogramming.section.lecture33.updowncasting;


public class MainTest {
    public static void main(String[] args) {
        Machine machine = new Machine();
        Camera camera = new Camera();
        
        machine.start();
        camera.start();
        camera.snap();
        
        // Upcasting
        Machine machine1 = camera;
        machine1.start();
        // error machine1.snap();
        // Down Casting 
        Machine machine2= new Camera();
        Camera camera1=(Camera) machine2;
        camera1.start();
        camera1.snap();
        
        // ClasCastException error RT error
        Machine machine3= new Machine();
        Camera camera2=(Camera) machine3;
        //camera2.snap();
        //camera2.start();
        
    }

}

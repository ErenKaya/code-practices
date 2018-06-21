
package com.caveofprogramming.section.lecture36.annoymousclasses;


public class MainTest {
    public static void main(String[] args) {
        Machine machine=new Machine(){
            @Override
            public void start() {
                System.out.println("Camera Snapping");
            }
            
        };
         machine.start();
        Plant plant = new Plant(){
            public void grow() {
                System.out.println("The plant growing..");
            }
            
        };
        plant.grow();
    }

}

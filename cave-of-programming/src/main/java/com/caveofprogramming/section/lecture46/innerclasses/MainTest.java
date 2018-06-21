
package com.caveofprogramming.section.lecture46.innerclasses;


public class MainTest {
    public static void main(String[] args) {
        Robot robot = new Robot(7);
        robot.start();
        
//        Robot.Brain brain=robot.new Brain(); // actualy this gonna work with access modifier "public"
//        brain.think();
           Robot.Battery battery = new Robot.Battery();
           battery.charge();
    }

}

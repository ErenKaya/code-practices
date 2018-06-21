
package com.caveofprogramming.section.lecture20;


public class RobotTest {
    public static void main(String[] args) {
        Robot sam=new Robot();
        sam.speak();
        sam.speak("I ama a robot and I was creating by Eren");
        sam.jump(12);
        sam.running("East", 200);
    }

}

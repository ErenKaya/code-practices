
package com.caveofprogramming.section.lecture20;


public class Robot {
    public void speak(){
        System.out.println("Hello");
    }
    public void speak(String text){
        System.out.println(text);
    }
    public void jump(int height){
        System.out.println("Jumping: "+ height);
    }
    public void running(String direction, double distance){
        System.out.println("Running: "+ distance+" metres in "+direction);
    }

}

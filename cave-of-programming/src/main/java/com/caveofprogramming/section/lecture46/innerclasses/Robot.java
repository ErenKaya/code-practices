package com.caveofprogramming.section.lecture46.innerclasses;

public class Robot {

    private int robotId;

    public Robot(int robotId) {
        this.robotId = robotId;
    }

    public class Brain {

        public void think() {
            System.out.println("Robot " + robotId + " is thinking ");
        }
    }
    public static class Battery{
        public void charge(){
            System.out.println("Battery charging");
        }
    }

    public void start() {
        System.out.println("Starting robot " + robotId);
        Brain brain = new Brain();
        brain.think();
        final String name= "Robert";
        
        class Temp{
            public void doSomething(){
                System.out.println("Id is: "+ robotId);
                System.out.println("My name is: "+ name);
            }
        }
        Temp temp=new Temp();
        temp.doSomething();
    }
    

}

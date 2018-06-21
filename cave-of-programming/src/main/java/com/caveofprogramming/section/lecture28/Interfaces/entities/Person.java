
package com.caveofprogramming.section.lecture28.Interfaces.entities;

import com.caveofprogramming.section.lecture28.Interfaces.anchestor.Info;
import com.caveofprogramming.section.lecture28.Interfaces.anchestor.Movement;


public class Person implements  Movement,Info{
    public int personId=2232222;
    public String personName="Eren";
    
    public void greet(){
        System.out.println("Hello there!");
    }

    public void move() {
        System.out.println("Person is moving from here");
    }

    public void showInfo() {
        System.out.println("Person identity number is: "+personId+" and name is "+personName);
    }

}

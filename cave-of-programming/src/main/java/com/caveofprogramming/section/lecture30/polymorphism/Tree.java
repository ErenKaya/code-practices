
package com.caveofprogramming.section.lecture30.polymorphism;


public class Tree extends Plant{

    @Override
    public void grow() {
        System.out.println("Tree growing!");
    }
    public void shedLeaves(){
        System.out.println("The leaves shedding");
    }
}

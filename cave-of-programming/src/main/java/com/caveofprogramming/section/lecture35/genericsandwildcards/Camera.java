package com.caveofprogramming.section.lecture35.genericsandwildcards;

public class Camera extends Machine {

    @Override
    public String toString() {
        return "I am a Camera";
    }
    public void snap(){
        System.out.println("Photo taken");
    }
}

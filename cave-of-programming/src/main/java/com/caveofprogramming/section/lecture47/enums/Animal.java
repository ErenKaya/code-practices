
package com.caveofprogramming.section.lecture47.enums;


public enum Animal {
    DOG("Fredie"),CAT("Tom"),MOUSE("Jerry");
    private String name;
    Animal(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "This animal called: "+name;
    }
}

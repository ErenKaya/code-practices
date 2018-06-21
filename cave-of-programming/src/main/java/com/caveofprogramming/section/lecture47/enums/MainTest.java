
package com.caveofprogramming.section.lecture47.enums;


public class MainTest {
    public static void main(String[] args) {
        Animal animal = Animal.CAT;
        
        switch(animal){
            case CAT:
                System.out.println("Cat");
                break;
            case DOG:
                System.out.println("Dog");
                break;
            case MOUSE:
                System.out.println("Mouse");
                break;
            default:
                System.out.println("Yanlış");
        }
        System.out.println(animal.CAT);
        System.out.println("Enum name as a string: "+animal.CAT.name());
        System.out.println(animal.CAT.getClass());
        System.out.println(animal.CAT instanceof Animal);
        Animal animal2 = Animal.valueOf("CAT");
        System.out.println(animal2);
        
    }

}

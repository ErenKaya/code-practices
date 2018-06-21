package com.caveofprogramming.section.lecture34.generics;

import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {

        ///////////////Before Java 5 ////////////////////
        ArrayList fruitList = new ArrayList();
        fruitList.add("Mandalina");
        fruitList.add("Portakal");
        fruitList.add("Elma");
        String giveMeOneFruit = (String) fruitList.get(1);
        System.out.println(giveMeOneFruit);

        ///////////Modern ArrayList //////////
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Köpek");
        animalList.add("Kedi");
        animalList.add("Timsah");
        String giveMeOneAnimal = animalList.get(0);
        System.out.println(giveMeOneAnimal);
        for (String animal : animalList) {
            System.out.println(animal);
        }

    }

}

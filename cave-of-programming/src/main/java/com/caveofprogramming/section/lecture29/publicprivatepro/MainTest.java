
package com.caveofprogramming.section.lecture29.publicprivatepro;

import com.caveofprogramming.section.lecture29.publicprivatepro.subclasses.Plant;
import com.caveofprogramming.section.lecture29.publicprivatepro.subclasses.Oak;


public class MainTest {
    public static void main(String[] args) {
        Plant plant = new Plant();
        System.out.println(plant.name);
        System.out.println(plant.ID);
        
        // Won't showed because size is private so this class should be in same class
        //System.out.println(plant.size);
        
        
        Plant plant1=new Oak();
        
    }

}

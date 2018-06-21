
package com.caveofprogramming.section.lecture29.publicprivatepro.subclasses;


public class Oak extends Plant{

    public Oak() {
    Plant plant=new Plant();
        System.out.println(this.height);
        System.out.println(this.size); 
        System.out.println(this.name);
       // Won't showed because size is private so this class should be in same class
       // System.out.println(plant.size); 
    }
    
    
}

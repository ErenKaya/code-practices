
package com.caveofprogramming.section.lecture31.encapsulation;


public class MainTest {
    public static void main(String[] args) {
        Costumer costumer = new Costumer();
        costumer.setCostumerId(2);
        costumer.setCostumerName("Eren");
        costumer.setMountlySalary(2000);
        
        System.out.println(costumer.getCostumerId()+" "
                +costumer.getCostumerName()+ " "
                +costumer.getMountlySalary());
    }

}

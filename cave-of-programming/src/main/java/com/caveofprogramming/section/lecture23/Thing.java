
package com.caveofprogramming.section.lecture23;


public class Thing {
    public static final int LUCKY_NUMBER=7;
    public String name;
    public static String description;
    
    public static int count;
    public int id;

    public Thing() {
        id=count;
        count++;
    }
    
    
    public void showName(){
        System.out.println("Object Id " + ","
                +id
                +"Object Info " + ";"
                +description
                +"Object Name: "
                +name);
        
    }
    public static void showInfo(){
        System.out.println(description);
        
    }
    

}

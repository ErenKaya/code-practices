
package com.caveofprogramming.section.lecture40.runtimevscheckedexception;


public class MainTest {
    public static void main(String[] args) {
        String[] strings={"zero","one","three"};
        // RuntimeException its not a compiler error
        try{
            System.out.println(strings[3]);
        }catch(ArrayIndexOutOfBoundsException x){
            System.out.println("Bir hatayla karşılaşıldı \n" + x.toString());
            
        }
    }

}

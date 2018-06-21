
package com.caveofprogramming.section2.lecture53.arraylist;

import java.util.ArrayList;


public class MainTest {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(20);
        numberList.add(220);
        numberList.add(203);
        
        
        System.out.println(numberList.get(0));
        for(Integer number : numberList){
            System.out.println(number);
        }
    }

}


package com.caveofprogramming.section2.lecture62.iterators;

import java.util.Iterator;
import java.util.LinkedList;


public class MainTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("dog");
        linkedList.add("cat");
        linkedList.add("mouse");
        
        Iterator<String> it=linkedList.iterator();
        while(it.hasNext()){
            String value=it.next();
            System.out.println("Older Iterator element="+value);
            if(value.equals("cat")){
                System.out.println("The finded execute the value is in the list="+value);
            }
        }
        //Modern iteration java 5 and later//
        for(String item: linkedList){
            System.out.println("LinkedList element="+item);
        }
    }

}

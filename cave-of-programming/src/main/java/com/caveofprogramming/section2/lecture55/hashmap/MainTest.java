package com.caveofprogramming.section2.lecture55.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(6, "six");
        hashMap.put(7, "seven");
        
        String text=hashMap.get(3);
        System.out.println(text);
        for(Map.Entry<Integer, String> entry: hashMap.entrySet()){
            int key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+": "+value);
        }
    }

}

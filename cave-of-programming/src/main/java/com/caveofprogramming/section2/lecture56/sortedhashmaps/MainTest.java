package com.caveofprogramming.section2.lecture56.sortedhashmaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        mapTest(hashMap);
        System.out.println("---------------");
        mapTest(linkedMap);
        System.out.println("---------------");
        mapTest(treeMap);


    }

    public static void mapTest(Map<Integer, String> map) {
        map.put(4, "kaplumbağa");
        map.put(2, "KOÇ");
        map.put(1, "keçi");
        map.put(5, "inek");
        map.put(11, "kedi");
        map.put(12, "köpek");

        for (Integer integer : map.keySet()) {
            String value = map.get(integer);
            System.out.println(integer + ": " + value);
        }
    }

}

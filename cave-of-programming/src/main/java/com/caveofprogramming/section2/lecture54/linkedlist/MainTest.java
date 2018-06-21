package com.caveofprogramming.section2.lecture54.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }

    public static void doTimings(String type, List<Integer> list) {
        for (int i = 0; i < 1E5; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e5; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("Type: "+ type+ "Toplam geçen süre="+(end-start));
    }

}

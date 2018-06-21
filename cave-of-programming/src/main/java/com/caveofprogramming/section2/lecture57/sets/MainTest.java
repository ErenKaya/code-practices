package com.caveofprogramming.section2.lecture57.sets;

import java.util.HashSet;
import java.util.Set;

public class MainTest {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        if (set1.isEmpty()) {
            System.out.println("Set is empty before adding");
        }
        set1.add("dog");
        set1.add("cat");
        set1.add("mouse");
        set1.add("snake");
        set1.add("cayote");

        System.out.println(set1);

        if (!set1.isEmpty()) {
            System.out.println("Set is full after adding");
        }
        Set<String> set2 = new HashSet<>();
        set2.add("dog");
        set2.add("cat");
        set2.add("tilki");
        set2.add("kurt");
        set2.add("kuzu");

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);

        /// diffrence///
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);
    }

}

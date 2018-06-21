
package com.caveofprogramming.section2.lecture64.decidingwhichjavacollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MainTest {
    public static void main(String[] args) {
           /* 
         * Consider:
         * 1. what you need the collection to do
         * 2. are you using the fastest collection for your purposes
         * (think about insertion/deletion, retrieval and traversal
         */
         
        //////////////// LISTS ///////////////////////////////////
         
        // Store lists of objects
        // Duplicates are allowed
        // Objects remain in order
        // Elements are indexed via an integer
        // cf. shopping list
        // Checking for particular item in list is slow
        // Looking an item up by index is fast
        // Iterating through lists is relatively fast
        // Note: you can sort lists if you want to.
         
        // If you only add or remove items at end of list, use ArrayList.
        List<String> list1 = new ArrayList<>();
         
        // Removing or adding items elsewhere in the list?
        List<String> list2 = new LinkedList<>();
         
        ////////////////SETS ///////////////////////////////////
         
        // Only store unique values
        // Great for removing duplicates
        // Not indexed, unlike lists
        // Very fast to check if a particular object exists
        // If you want to use your own objects, you must implement hashCode() and equals().
         
        // Order is unimportant and OK if it changes?
        // HashSet is not ordered.
        Set<String> set1 = new HashSet<>();
         
        // Sorted in natural order? Use TreeSet - must implement Comparable for custom types
        // (1,2,3 ..., a,b,c.... etc)
        Set<String> set2 = new TreeSet<>();
         
        // Elements remain in order they were added
        Set<String> set3 = new LinkedHashSet<>();
         
        ////////////////MAPS ///////////////////////////////////
         
        // Key value pairs.
        // Like lookup tables
        // Retrieving a value by key is fast
        // Iterating over map values is very slow
        // Maps not really optimised for iteration
        // If you want to use your own objects as keys, you must implement hashCode() and equals().
         
        // Keys not in any particular order, and order liable to change.
        Map<String, String> map1 = new HashMap<>();
         
        // Keys sorted in natural order - must implement Comparable for custom types
        Map<String, String> map2 = new TreeMap<>();
         
        // Keys remain in order added 
        Map<String, String> map3 = new LinkedHashMap<>();
         
        // There are also the SortedSet and SortedMap interfaces.
    }

}

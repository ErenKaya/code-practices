package com.caveofprogramming.section.lecture38.handlingexceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainTest {

    public static void main(String[] args) {
        File textFile = new File("test.txt");
        try {
            FileReader fReader = new FileReader(textFile);
            // This code will be not executed if an exception thrown
            System.out.println("Continuing...");
        }catch(FileNotFoundException e){
            System.out.println("File not fount :" + textFile.toString());
        }
        System.out.println("Finished.");
    }

}

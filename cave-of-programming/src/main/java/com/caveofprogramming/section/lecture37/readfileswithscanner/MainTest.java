package com.caveofprogramming.section.lecture37.readfileswithscanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String fileName = "C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\example.txt";
        File textFile = new File(fileName);
        Scanner scanner = new Scanner(textFile);
        int value = scanner.nextInt();
        System.out.println(value);
        int count = 2;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(count + ": " + line);
            count++;
        }
    }

}

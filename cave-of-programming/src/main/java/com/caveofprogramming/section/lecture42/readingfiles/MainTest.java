package com.caveofprogramming.section.lecture42.readingfiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainTest {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\example.txt";
        BufferedReader bReader = null;
        try {
            FileReader fReader = new FileReader(fileName);
            bReader = new BufferedReader(fReader);
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Istediğiniz dosya bulunamadı.. "
                    + fileName.toString());
        } catch (IOException e) {
            System.out.println("İstediğinz dosya okunamadı. "
                    + fileName.toString());
        } finally {
            try {
                bReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch(NullPointerException ex){
                System.out.println("Your file never opened.");
            }
        }
    }

}

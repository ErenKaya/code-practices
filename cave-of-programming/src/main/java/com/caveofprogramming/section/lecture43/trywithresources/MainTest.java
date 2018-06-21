
package com.caveofprogramming.section.lecture43.trywithresources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MainTest {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\example.txt");
        try(BufferedReader bReader=new BufferedReader(new FileReader(file))){
            String line;
                    while( (line=bReader.readLine()) != null){
                        System.out.println(line);
                    }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found"+file.toString());
        } catch(IOException ex){
            System.out.println("Unable to read"+file.toString());
        }
    }

}


package com.caveofprogramming.section.lecture44.writingtextfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainTest {
    public static void main(String[] args) {
        File file=new File("text2");
        try(BufferedWriter bWriter=new BufferedWriter(new FileWriter(file))){
            bWriter.write("This is line one");
            bWriter.newLine();
            bWriter.write("This is line two");
            bWriter.newLine();
            bWriter.write("This is line three");
            bWriter.newLine();
            bWriter.write("This is line four");
        } catch(IOException ex){
            System.out.println("Unable to read"+file.toString());
        }
    }

}


package com.caveofprogramming.section.lecture50.serializablingarrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ReadObjects {
    public static void main(String[] args) {
        System.out.println("Objects reading...");
        try(FileInputStream fiStream=new FileInputStream("C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\people.bin")){
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);
//            Person person1=(Person)oiStream.readObject();
//            Person person2=(Person)oiStream.readObject();
            Person[] person=(Person[])oiStream.readObject();
            System.out.println(person);
            oiStream.close();
//            System.out.println(person1);
//            System.out.println(person2);
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}

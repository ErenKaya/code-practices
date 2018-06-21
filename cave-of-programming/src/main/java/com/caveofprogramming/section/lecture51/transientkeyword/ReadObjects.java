package com.caveofprogramming.section.lecture51.transientkeyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjects {

    public static void main(String[] args) {
        System.out.println("Objects reading...");
        try (ObjectInputStream oiStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\test.bin"))) {

            Person person1 = (Person) oiStream.readObject();
            Person person2 = (Person) oiStream.readObject();
            System.out.println(person1);
            System.out.println(person2);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}

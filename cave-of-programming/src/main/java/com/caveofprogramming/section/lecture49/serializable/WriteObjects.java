package com.caveofprogramming.section.lecture49.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

    public static void main(String[] args) {
        System.out.println("Objects writing...");
        Person person1 = new Person(4, "Eren");
        Person person2 = new Person(2, "Fatih");

        System.out.println(person1);
        System.out.println(person2);
        try (FileOutputStream foStream = new FileOutputStream
        ("C:\\Users\\ErenKaya\\Documents\\NetbeansFileReaderTest\\people.bin")) {
            ObjectOutputStream ooStream = new ObjectOutputStream(foStream);
            ooStream.writeObject(person1);
            ooStream.writeObject(person2);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

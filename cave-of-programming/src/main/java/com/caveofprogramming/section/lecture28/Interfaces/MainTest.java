package com.caveofprogramming.section.lecture28.Interfaces;

import com.caveofprogramming.section.lecture28.Interfaces.anchestor.Info;
import com.caveofprogramming.section.lecture28.Interfaces.entities.Machine;
import com.caveofprogramming.section.lecture28.Interfaces.entities.Person;

public class MainTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.greet();
        person.move();

        Machine machine = new Machine();
        machine.start();
        machine.move();

        outputInfo(machine);
        outputInfo(person);
    }

    public static void outputInfo(Info info) {

        info.showInfo();

    }

}

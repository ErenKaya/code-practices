package com.caveofprogramming.section.lecture35.genericsandwildcards;

import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {
        ArrayList<Machine> machineList = new ArrayList<Machine>();
        machineList.add(new Machine());
//        machineList.add(new Machine());
        ArrayList<Camera> cameraList = new ArrayList<Camera>();
        cameraList.add(new Camera());
//        cameraList.add(new Camera());

        showWildCardList(machineList);
        showCameraList(cameraList);
        showMachineList(machineList);

    }

    public static void showWildCardList(ArrayList<?> wildCardList) {
        for (Object object : wildCardList) {
            System.out.println(object);

        }
    }

    public static void showCameraList(ArrayList<? extends Camera> cameraList) {
        for (Camera camera : cameraList) {
            System.out.println(camera);
            camera.snap();
        }
    }

    public static void showMachineList(ArrayList<? extends Machine> machineList) {
        for (Machine machine : machineList) {
            System.out.println(machine);
            machine.start();
        }
    }

}

package com.caveofprogramming.section.lecture41.abstractclasses;

public abstract class Machine {

    private int machineId;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    public abstract void start();
    public abstract void doStuff();
    public abstract void shutDown();
    
    public void run(){
        start();
        doStuff();
        shutDown();
    }
}

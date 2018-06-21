
package com.caveofprogramming.section.lecture31.encapsulation;


public class Costumer {
    private int costumerId;
    private String costumerName;
    private int mountlySalary;

    public Costumer(int costumerId, String costumerName, int mountlySalary) {
        this.costumerId = costumerId;
        this.costumerName = costumerName;
        this.mountlySalary = mountlySalary;
    }

    public Costumer() {
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public int getMountlySalary() {
        return mountlySalary;
    }

    public void setMountlySalary(int mountlySalary) {
        this.mountlySalary = mountlySalary;
    }
    

}

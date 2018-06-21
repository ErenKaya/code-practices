package com.caveofprogramming.section.lecture28.Interfaces.entities;

import com.caveofprogramming.section.lecture28.Interfaces.anchestor.Info;
import com.caveofprogramming.section.lecture28.Interfaces.anchestor.Movement;

public class Machine implements Info, Movement {

	public long machineId = 1;
	public String machineName = "Machine type 1";

	public void start() {
		System.out.println("Machine has started.");
	}

	public void move() {
		System.out.println("The Machine is moving from here");
	}

	public void showInfo() {
		System.out.println("Machine number is: " + machineId + " and name is " + machineName);
	}

}

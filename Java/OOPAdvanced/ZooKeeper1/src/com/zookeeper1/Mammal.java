package com.zookeeper1;

public class Mammal {
	Integer energyLevel = 100;
	
	public Integer displayEnergy() {
		System.out.println("current energy level is " + energyLevel);
		return energyLevel;
	}

}

package com.zookeeper1;

public class Gorilla extends Mammal {
	public void throwSomthing() {
		System.out.println("the Gorilla has thrown somthing");
		this.energyLevel -= 5;
		displayEnergy();
	}
	public void eatBananas() {
		System.out.println("the Gorilla has eaten a Banana");
		this.energyLevel += 10;
		displayEnergy();
	}
	public void climb() {
		System.out.println("the Gorilla has climbed a tree");
		this.energyLevel -= 10;
		displayEnergy();
	}
}

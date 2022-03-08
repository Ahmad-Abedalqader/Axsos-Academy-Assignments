package com.zookeeper2;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
		System.out.println("the currunt Energy level is : "+ this.displayEnergy());
	}

	public void fly() {
		System.out.println("The Bat just flew");
		this.energyLevel -= 50;
		displayEnergy();
	}
	public void eatHumans() {
		System.out.println("The bat just ate.....");
		this.energyLevel += 25;
		displayEnergy();
	}
	public void attackTown() {
		System.out.println("The bat just ate.....");
		this.energyLevel -= 100;
		displayEnergy();
	}
}


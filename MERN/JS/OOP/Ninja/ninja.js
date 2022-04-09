class Ninja{
    constructor(name){
        this.health = 0;
        this.name = name;
        this.speed = 3;
        this.strength = 3;
    }
    sayName(){
        console.log(`your name is ${this.name}`);
    }
    showStats(){
        console.log(`Ninja name: ${this.name}`);
        console.log(`Strength: ${this.strength}`);
        console.log(`Speed: ${this.speed}`);
        console.log(`Health: ${this.health}`);
    }
    drinkSake(){
        this.health += 10;
    }
}
const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.drinkSake();
ninja1.showStats();

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

class Sensei extends Ninja{
    constructor(name){
        super(name);
        this.wisdom = 10;
    }
    speakWisdom(){
        super.drinkSake();
        console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
}
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();

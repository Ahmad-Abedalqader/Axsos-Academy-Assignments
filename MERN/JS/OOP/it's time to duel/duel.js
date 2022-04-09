class Card{
    constructor(name, cost){
        this.name = name;
        this.cost = cost;
    }
}
class Unit extends Card{
    constructor(name, cost, power, res){
        super(name, cost);
        this.power = power;
        this.res = res;
    }
    attack(target){
        if(target instanceof Unit){
            target.res -= this.power;
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

class Effect extends Card{
    constructor(name, cost, stat, magnitude){
        super(name, cost);
        this.stat = stat;
        this.magnitude = magnitude;
        if (magnitude>0){
            this.text = "increase target's " + stat + "by " + magnitude
        }else{
            this.text = "reduce target's " + stat + "by " + magnitude
        }
    }
    play(target){
        if(target instanceof Unit){
            if(this.stat == "resilience"){
                target.res += this.magnitude;
            }else if(this.stat == "power"){
                target.power += this.magnitude;
            }
        } else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

const redUnit = new Unit ("Red Belt Ninja", 3, 3, 4);
const blackUnit = new Unit ("Black Belt Ninja", 4, 5, 4);

const effect1 = new Effect ("Hard Algorithm", 2, "resilience", 3);
const effect2 = new Effect ("Unhandled Promise Rejection", 1, "resilience", -2);
const effect3 = new Effect ("Pair Programming", 3, "power", 2);

effect1.play(redUnit);
effect2.play(blackUnit);
effect3.play(redUnit);

redUnit.attack(blackUnit);

console.log(blackUnit.res);

function pizzaOven(crustType, sauceType, cheese, toppings) {
    var pizza = {};
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheese = cheese;
    pizza.toppings = toppings;
    return pizza;
}

var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage", "arugula"]);
console.log("pizza 1 is:\n", pizza1);
var pizza2 = pizzaOven("hand tossed ", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
console.log("pizza 2 is:\n", pizza2);
var pizza3 = pizzaOven("hand tossed ", "traditional", ["mozzarella", "provolone"], ["olives ", "onions"]);
console.log("pizza 3 is:\n", pizza3);
var pizza4 = pizzaOven("deep dish ", "marinara", ["mozzarella", "feta"], ["mushrooms", "sweet pepper"]);
console.log("pizza 4 is:\n", pizza4);



var crustType =["deep dish","hand tossed","cracker crust", "thin crust"];
var sauceType=["marinara", "traditional","white creamy sauce", "barbecue sauce"];
var cheese = [["feta", "mozzarella"],["mozzarella"], ["porvolone", "mozzarilla"], ["goat cheese", "chedder"]];
var toppings = [["pepperoni", "sausage", "arugula"],["mushrooms", "sweet pepper"],["olives ", "onions"],["mushrooms", "olives", "onions"]];

function randomPizza() {
    var pizza = {};
    pizza.crustType = crustType[Math.floor( crustType.length * Math.random())];
    pizza.sauceType = sauceType[Math.floor(Math.random() * sauceType.length)];
    pizza.cheese = cheese[Math.floor(Math.random() * cheese.length)];
    pizza.toppings = toppings[Math.floor(Math.random() * toppings.length)];
    return pizza;
}
var random_pizza = randomPizza();
console.log("A random pizza may be:\n", random_pizza);
function printodds(){
for (var i = 1; i <= 20; i++){
    if (i%2!=0){
    console.log(i);
    }
}
}
console.log("odds numbers from 1 to 20 are:")
printodds();

function divisibleby3(){
    for(var i=100; i>=0; i--){
        if (i%3==0){
            console.log(i);
        }
    }
}
console.log("divisible numbres by 3 from 100 to 0 are:");
divisibleby3();

function sequance(){
    for (i=4; i>=-3.5; i-=1.5){
        console.log(i);
    }
}
console.log("the sequance is:")
sequance();

var sum=0;
function sigma(){
    for(var i=1; i<=100; i++){
        sum=sum+i;
    }
    return sum;
}
sigma();
console.log("sigma of 100 is:", sum);

var product=1;
function factorial(){
    for(var i=1; i<=12; i++){
        product=product*i;
    }
    return product;
}
factorial();
console.log("factorial of 12 is:", product);


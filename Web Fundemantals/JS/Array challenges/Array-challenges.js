function alwaysHungry(arr) {
    var x=0;
    for(var i=0; i<arr.length; i++){
        if (arr[i]=="food"){
            console.log("yummy");
            x++;
        }
    }
    if (x==0){
        console.log("I'm hungry");
    }
}

alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"

/*****************************************************/

function highPass(arr, cutoff) {
    var filteredArr = [];
    for(var i=0; i<arr.length; i++)
    if (arr[i]>cutoff){
        filteredArr.push(arr[i]);
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]

/***********************************************************/

function betterThanAverage(arr) {
    var sum = 0;
    for(var i=0; i<arr.length; i++){
        sum = arr[i]+sum;
    }
    var avg =sum/arr.length;
    
    var count = 0;
    for(var i=0; i<arr.length; i++){
        if (arr[i]>avg){
            count++;
        }
    }
    return count;
}
var result1 = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result1);

/*****************************************************************/

function reverse(arr) {
    var newarr=[];
for(var i=arr.length-1; i>=0; i--){
    newarr.push(arr[i])
}
    return newarr;
}
var result2 = reverse(["a", "b", "c", "d", "e"]);
console.log(result2); // we expect back ["e", "d", "c", "b", "a"]

/***********************************************************************/

function fibonacciArray(n) {
    var fibArr = [0, 1];
    for(i=2; i<n; i++)
    fibArr.push(fibArr[i-2]+fibArr[i-1]);
    return fibArr;
}
var result3 = fibonacciArray(10);
console.log(result3); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
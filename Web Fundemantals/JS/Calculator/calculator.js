var num1="";
var num2="";
var operator='';
var result=0;
var display=document.querySelector("#display");
var selectedoperator=document.querySelector(".operator");
var equals=document.querySelector("#equals");
function press(num){
    display.innerText=num1+num;
    if (operator == ''){
        display.innerText=num1+num;
        num1= display.innerText;
    }
    else{
        display.innerText=num2+num;
        num2=display.innerText;
    }
}
function setOP(op){
    display.innerText=op;
    operator=op;
    console.log(operator);
}
function calculate(){
    if (operator=='/'){
        result=parseInt(num1)/parseInt(num2);
    }
    else if (operator=='*'){
        result=parseInt(num1)*parseInt(num2);
    }
    else if (operator=='+'){
        result=parseInt(num1)+parseInt(num2);
    }
    else if (operator=='-'){
        result=parseInt(num1)-parseInt(num2);
    }
    display.innerText=result;
    num1=result.toString();
    num2=0;
    operator='';
}
function clr(){
    num1=0,num2=0;
    operator='';
    display.innerText=0;
}


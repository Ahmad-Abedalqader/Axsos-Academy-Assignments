var element=document.querySelector("footer");
function remove(){
    element.remove();
}

function change(degree){
for(var i=1; i<9; i++){
    var temp=document.querySelector("#temp"+i);
    console.log(i);
    if(degree.value == "°F"){
        temp.innerText= Math.round((parseInt(temp.innerText))*9/5+32);
    }
    else{
        temp.innerText= Math.round((parseInt(temp.innerText)-32)*5/9);
    }
}
}

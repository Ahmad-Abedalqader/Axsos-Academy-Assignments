console.log("page loaded...");

var v = document.getElementById("thevideo");

function playit() {
    v.play();
    v.muted = false;
    return x;
}

function pauseit() {
    v.pause();
}

function hover() {
    v.muted = true;
    v.play();
}

function unhover() {
    v.pause();
    v.currentTime = 0;
}
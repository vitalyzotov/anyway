document.addEventListener("DOMContentLoaded", function () {
    console.log("I am loaded");
    let myform = document.getElementById("signup-form");
    myform.addEventListener("submit", function (event){
    console.log("Submited")
    event.preventDefault();
    })
    });


// Functions to change login status and what is shown in the navBar
var status;

statusCheck()
showAll()


function statusCheck(){
status = localStorage.getItem('status')
if(!status){
status = 'loggedOut'
localStorage.setItem('status', status)}
}

function changeStatusLoggedIn(){
status = localStorage.getItem('status')
status = 'loggedIn'
localStorage.setItem('status', status)
}

function showAll(){
var elements = document.getElementsByClassName('nav-link')
 if(status === 'loggedIn'){
 for (var element of elements) {
    element.classList.remove('d-none');
}
}
}

//Functions to show the contact info, when pushing "buy meal"
function showContactInfo(){
var element = document.getElementById('myDiv')
element.classList.remove('d-none')
}

//Function to show the selected type of foodchoice
function showVegetarian() {
  var elements = document.getElementsByClassName('meal');
  for (var i = 0; i < elements.length; i++) {
    var element = elements[i];
    if (!element.classList.contains('vegetarian')) {
      element.classList.add('d-none');
    }
  }
}





//function pictureFlip(){
//    var element = document.getElementById('picture');
//    element.classList.toggle("active");
//
//    if(element.classList.contains('active')){
//      document.getElementById('picture').src = "https://img.freepik.com/free-vector/green-restaurant-menu-background_23-2147490040.jpg?w=2000";
//      }  else{
//              document.getElementById('picturex').src = "https://www.nicepng.com/png/full/772-7729123_join-the-campaign-to-reduce-food-waste-in.png";
//              }
//}


//
//function userLoggedIn() {
//  var elements = document.getElementsByClassName('nav-link');
//  for (var i = 0; i < elements.length; i++) {
//    elements[i].classList.add('loggedIn');
//  }
//}
//
//function navVisible() {
//  var elements = document.getElementsByClassName('nav-link');
//  for (var element of elements) {
//    if (element.classList.contains('loggedIn')) {
//      element.classList.remove('d-none');
//    }
//  }
//}
//Javascript til category buttons.
//function changeActive1(){
//var element = document.getElementbyId('catBtn1');
//element.classList.toggle('active')
//
//if(element.classList.contains('active')){
//document.getElementById('catBtn1').
//
//}
//}

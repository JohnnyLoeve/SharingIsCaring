function pictureFlip(){
    var element = document.getElementById('picture');
    element.classList.toggle("active");

    if(element.classList.contains('active')){
      document.getElementById('picture').src = "https://img.freepik.com/free-vector/green-restaurant-menu-background_23-2147490040.jpg?w=2000";
      }  else{
              document.getElementById('picturex').src = "https://www.nicepng.com/png/full/772-7729123_join-the-campaign-to-reduce-food-waste-in.png";
              }
}

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
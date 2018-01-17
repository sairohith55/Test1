 var count = 1;
function changeImage(n,imgId) {
    count += n;
    var x = document.getElementsByClassName(imgId);
    if (count > x.length) {
        count = 1;
    } 
    if (count < 1) {
        count = x.length;
    }
    for (var i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    x[count-1].style.display = "block"; 
    }
function showHideImg(formId,msg){
   document.getElementById(formId).style.display=msg;
    document.getElementById('popup').style.display=msg;
   
}
function colorImg(msg,obj){
    obj.src = msg;
}
var logger;
function setLogin(msg){
    logger=msg;
}

function userLogin(){
   var obj=document.getElementById('loginform1');
    obj.action=logger;
    obj.submit();
}function addRecipes(formId,msg){
   document.getElementById('recipeList').style.display='none';
    document.getElementById(formId).style.display=msg;
    document.getElementById('popup').style.display=msg;
    
   
}
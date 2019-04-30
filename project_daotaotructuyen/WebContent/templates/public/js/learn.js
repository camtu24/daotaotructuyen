function openNav() {
  document.getElementById("full").style.width = "100%";
  document.getElementById("overflow1").style.width = "0";
}
function closeNav() {
  document.getElementById("full").style.width = "70%";
  document.getElementById("overflow1").style.width = "30%";
}

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent1");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
//Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


////////////////////////////////////////////////////
function showReply(idCmt){  
   $(".reply-action-"+idCmt).slideToggle();
}

////////////////////////////////////////////////////

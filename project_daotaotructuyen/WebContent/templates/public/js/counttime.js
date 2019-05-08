//FUNCTION THAT GETS THE REMAINING TIME TILL DEADLINE SET
function getTimeRemaining(endtime) {
  
  var t = Date.parse(endtime) - Date.parse(new Date());
  var seconds = Math.floor((t / 1000) % 60);
  var minutes = Math.floor((t / 1000 / 60) % 60);
  /*var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
  var days = Math.floor(t / (1000 * 60 * 60 * 24));*/
  return {
    'total': t,
    /*'days': days,
    'hours': hours,*/
    'minutes': minutes,
    'seconds': seconds
  };
}
//FUNCTION TO INITIALIZE CLOCK
function initializeClock(id, endtime) {
  var clock = document.getElementById(id);
  /*var daysSpan = clock.querySelector('.days');
  var hoursSpan = clock.querySelector('.hours');*/
  var minutesSpan = clock.querySelector('.minutes');
  var secondsSpan = clock.querySelector('.seconds');
//FUNCTION THAT UPDATES THE CLOCK
  function updateClock() {
    var t = getTimeRemaining(endtime);

    /*daysSpan.innerHTML = t.days;
    hoursSpan.innerHTML = ('0' + t.hours).slice(-2);*/
    minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
    secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);

    if (t.total < 0) {
      clearInterval(timeinterval);
	  //subm.click()
      nopBaiVaKetThuc(1);
    }

  }

  updateClock();
  var timeinterval = setInterval(updateClock, 1000);
}

  function getCookie(name) {
    //alert('hi')
    console.log("name ", name)
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
  }
  
  
  
  var deadline = new Date(Date.parse(new Date()) + 15 *  60 * 1000);
  /*if(document.cookie && document.cookie.match('myClock')){
    // var deadline = document.cookie.match(/(^|;)myClock=([^;]+)/)[2];
    var deadline = getCookie('myClock');
  }
 
  else{
    //Đặt thời gian của bạn ở đây !!!!
    var deadline = new Date(Date.parse(new Date()) + 5 * 60 * 1000);
 
    // store deadline in cookie for future reference
    document.cookie = 'myClock=' + deadline + '; path=/';
  }*/

initializeClock('clockdiv', deadline);

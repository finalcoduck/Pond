<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="main">
	<div class="container bg-primary">
		<div class="row vh5">
			<div class="col-12 vh5">
				<a class="close text-white" data-dismiss="modal">&times;</a>
			</div>
		</div>
		<div class="row vh10">
			<div class="col-12">
				<div style="font-size:50px;" class="text-center text-white" id="clock">
				</div>
			</div>
		</div>
		<div class="row vh80">	
			<div class="col-12 col-md-6 text-center">
			</div>
			<div class="col-12 col-md-6 text-center">
				<div id="qrCode" class="d-inline">
				</div>	
			</div>
		</div>
	</div>
</section>
<script src="${pageContext.request.contextPath }/resources/vendor/qrcodejs/qrcode.min.js" type="text/javascript"></script>
<script>

$(document).ready(function(){
	
	//시계 실행
	printClock();
	var qrcode = new QRCode(document.getElementById("qrCode"), {
	    text: "http://jindo.dev.naver.com/collie",
	    width: 128,
	    height: 128,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});

});
function getAttendedQRCode(){
	
	var data = {groupNum : '${groupVo.groupNum}'};
	var dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/srch/qrcode/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		
	});
}
function printClock() {
    
    var clock = document.getElementById("clock");            // 출력할 장소 선택
    var currentDate = new Date();                                     // 현재시간
    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    var amPm = 'AM'; // 초기값 AM
    var currentHours = addZeros(currentDate.getHours(),2); 
    var currentMinute = addZeros(currentDate.getMinutes() ,2);
    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
    
    if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
    	amPm = 'PM';
    	currentHours = addZeros(currentHours - 12,2);
    }

    if(currentSeconds >= 50){// 50초 이상일 때 색을 변환해 준다.
       currentSeconds = '<span style="color:#de1951;">'+currentSeconds+'</span>'
    }
    clock.innerHTML = currentHours+":"+currentMinute+":"+currentSeconds +" <span>"+ amPm+"</span>"; //날짜를 출력해 줌
    
    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
}

function addZeros(num, digit) { // 자릿수 맞춰주기
	  var zero = '';
	  num = num.toString();
	  if (num.length < digit) {
	    for (i = 0; i < digit - num.length; i++) {
	      zero += '0';
	    }
	  }
	  return zero + num;
}



</script>
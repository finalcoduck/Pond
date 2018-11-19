<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/login_style.css">

<section id="main">
	<div class="container bg-primary">
		<div class="row vh5">
			<div class="col-12 vh5">
				<a class="close text-white" data-dismiss="modal">&times;</a>
			</div>
		</div>
		<div class="row vh10 py-5">
			<div class="col-12">
				<div style="font-size:50px;" class="text-center text-white" id="clock">
				</div>
			</div>
		</div>
		<div class="row align-items-center vh80">	
			<div class="col-12 col-md-6 text-center">
				<svg id="ryan" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
                	<path d="M0,150 C0,65 120,65 120,150" fill="#ffcb01" stroke="#000" stroke-width="2" />
                    <circle cx="60" cy="60" r="40" fill="#ffcb01" stroke="#000" stroke-width="2" />
                    <g class="eyes">
                    	<!-- 왼쪽 눈과 눈썹-->
                        <ellipse cx="42" cy="57" rx="7" ry="8" fill="#000" />
                        <ellipse cx="43" cy="55" rx="1.5" ry="2" fill="#fff" />
                        <!-- 오른쪽 눈과 눈썹 -->
                        <ellipse cx="78" cy="57" rx="7" ry="8" fill="#000" />
                        <ellipse cx="77" cy="55" rx="1.5" ry="2" fill="#fff" />
                    </g>
                    <g class="muzzle">
                    	<path d="M40,79 C40,74.5 80,74.5 80,79" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                        <path d="M50,76 C60,69 60,69 70,76" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                        <path d="M40,79 C40,89 80,89 80,79" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                        <polygon points="62,72.5 62.5,73" fill="#000" stroke="#000" stroke-width="1" stroke-linejoin="round" />
                        <polygon points="58.5,72.5 58,73" fill="#000" stroke="#000" stroke-width="1" stroke-linejoin="round" />
                     </g>
                 </svg>
			</div>
			<div class="col-12 col-md-6 text-center">
				<div id="attendBtnSection">
					<p class="text-white">안녕하세요</p>
					<p class="text-white">본인 핸드폰의 출석버튼을 누른 후 화면의 출석 버튼을 눌러주세요</p>
					<a id="attendedBtn" href="javascript:;" class="code_view actionBtn9">
						 <span class="txt">출석</span>
					</a>
				</div>
				<div id="qrCode" class="d-none">
				</div>	
			</div>
		</div>
	</div>
</section>
<script src="${pageContext.request.contextPath }/resources/vendor/qrcodejs/qrcode.min.js" type="text/javascript"></script>
<script>

$(document).ready(function(){
	
	$("#attendedBtn").on("click",createQrCode);
	
	//시계 실행
	printClock();
	
});

function createQrCode(){
	var qrcode = new QRCode(document.getElementById("qrCode"), {
	    text: "http://jindo.dev.naver.com/collie",
	    width: 128,
	    height: 128,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});
	document.getElementById("qrCode").querySelector("img").className="d-inline";
	$("#attendBtnSection").addClass("d-none");
	$("#qrCode").removeClass("d-none");
}
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
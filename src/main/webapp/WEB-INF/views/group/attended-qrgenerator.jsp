<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/login_style.css">

<section id="main">
	<div class="container bg-primary">
		<div class="row vh5">
			<div class="col-12 vh5">
				<a class="close text-white" href="${pageContext.request.contextPath }/group/attended?groupNum=${groupVo.groupNum}">&times;</a>
			</div>
		</div>
		<div class="row vh10 py-5">
			<div class="col-12">
				<div style="font-size:50px;" class=".font-weight-bold text-center text-white" id="clock">
				</div>
			</div>
		</div>
		<div class="row align-items-center vh80">	
			<div class="col-12 col-md-6 text-center">
				<svg id="ryan" style="width:40%" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
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
				<div class="card shadow">
					<div class="card-body">
						<div id="attendBtnSection">
							<h3>안녕하세요</h3>
							<p class="my-5">본인 핸드폰의 출석버튼을 누른 후 화면의 출석 버튼을 눌러주세요</p>
							<button type="button" id="attendedBtn" class="btn btn-primary">
						 		출석
							</button>
						</div>
						<div id="qrCodeSection" class="d-none">
							<div class="progress mb-5">
							    <div id="QRcodeProgressBar" class="progress-bar progress-bar-striped progress-bar-animated bg-success w-100"></div>
							</div>
							<div id="qrCode"></div>
						</div>  
				    </div> 
				    
				</div>
			</div>
		</div>
	</div>
</section>
<script src="${pageContext.request.contextPath }/resources/vendor/qrcodejs/qrcode.min.js" type="text/javascript"></script>
<script>
<!-- Autoplay is allowed. -->
var alertSound = new Audio('${pageContext.request.contextPath }/resources/audio/barcode.mp3'); // 오디오 객체 생성
$(document).ready(function(){

	//alertSound.play();
	$("#attendedBtn").on("click",clickAttendedBtn);
	
	//시계 실행
	printClock();
	
});
var count = 4;
function clickAttendedBtn(){
	
	getAttendedQRCode();
	//0 25 50 75 100
	setTimeout("QRcodeTimer()",1000);
}

function createQrCode(attendedQRCode){
	var qrcode = new QRCode(document.getElementById("qrCode"), {
	    text: attendedQRCode,
	    width: 175,
	    height: 175,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});
	document.getElementById("qrCode").querySelector("img").className="d-inline";
}

function toggleQRcodeSection(){
	$("#attendBtnSection").toggleClass("d-none");
	$("#qrCodeSection").toggleClass("d-none");
}

function QRcodeTimer(){
	var progressCount = 25*count,
	progressWidth = "w-"+progressCount;
	QRcodeProgressBar = document.querySelector("#QRcodeProgressBar"),
	progressBarColor = 'bg-success ';
	
	// 여기서 Ajax 요청으로 출석을 했는지 확인하자~ 출석했으면 count -1로 해버려서 종료
	if(count !== -1){
		isUserAttended();
	}
	
	if(count === -1){
		count=4;
		toggleQRcodeSection();
		document.querySelector("#qrCode").innerHTML="";
		return;
	}
	switch(count){
	case 1:
		progressBarColor = 'bg-danger '
		break;
	case 2:
		progressBarColor = 'bg-warning '
		break;
	default:
		progressBarColor = 'bg-success '
		break;
	}
	
	QRcodeProgressBar.className="progress-bar progress-bar-striped progress-bar-animated "+progressBarColor+progressWidth;
	
	count--;
	
	setTimeout("QRcodeTimer()",1200);
}


function getAttendedQRCode(){
	
	var data = {groupNum : '${groupVo.groupNum}'},
	dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/attended/generate/qr/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		console.log(data);
		if(data.errC==="0000"){
			createQrCode(data.attendedQRCode);
			toggleQRcodeSection();
		}
	});
}
function isUserAttended(){
	
	var data = {groupNum : '${groupVo.groupNum}'},
	dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/attended/search/qr/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		console.log(data);
		if(data.errC==="0000"){
			if(data.attendedQRCode === null){
				count=-1;
				alertSound.play();
				//출석 성공 팝업
				let timerInterval;
				swal({
				  title: '반가워요',
				  html: '출석 되었습니다.',
				  type: 'success',
				  timer: 2000,
				  onClose: () => {
				    clearInterval(timerInterval)
				  }
				}).then((result) => {
				// Read more about handling dismissals
					if ( result.dismiss === swal.DismissReason.timer) {
						
					}
				})
			}
		}
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
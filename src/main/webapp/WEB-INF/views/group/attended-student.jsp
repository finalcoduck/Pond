<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resources/vendor/instascan/js/instascan.min.js" type="text/javascript"></script>


<section id="main">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-8">
			</div>
			
			<div id="calendar" class="col-12 col-md-8 mb-3">
			</div>
			
			<div class="col-12 col-md-8 mb-3">
				<button id="attendanceBtn" class="btn btn-primary btn-block">출석</button>
			</div>		
		</div>
	</div>
</section>

<!-- QR camera Modal -->
<div class="modal" id="attendedModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">QR코드 캡쳐</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			
			<!-- Modal body -->
			<div class="modal-body align_c">
				<video id="preview" class="max-vw85"></video>		
			</div>
	
		</div>
	</div>
</div>
<!-- QR camera Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/gcal.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/locale/ko.js" type="text/javascript"></script>

<script>

let opts = {
		  // Whether to scan continuously for QR codes. If false, use scanner.scan() to manually scan.
		  // If true, the scanner emits the "scan" event when a QR code is scanned. Default true.
		  continuous: true,
		  video: document.getElementById('preview'),
		  mirror: false,
		  captureImage: false,
		  backgroundScan: true,
		  
		  // Only applies to continuous mode. The period, in milliseconds, before the same QR code
		  // will be recognized in succession. Default 5000 (5 seconds).
		  refractoryPeriod: 5000,
		  
		  // Only applies to continuous mode. The period, in rendered frames, between scans. A lower scan period
		  // increases CPU usage but makes scan response faster. Default 1 (i.e. analyze every frame).
		  scanPeriod: 5
		};
let scanner = new Instascan.Scanner(opts);
var attendedStatus = false;
//getLocation();

scanner.addListener('scan', function (content) {
	
	console.log(content);
	console.log(attendedStatus);
	if(attendedStatus){
		attendedOut(content);
	}else{
		attendedIn(content);
	}
	
	scanner.stop();
});

$(document).ready(function(){
		
		$('#attendanceBtn').on('click',attended);
		
		
		//모달이 사라질 경우 카메라 꺼짐
		$('#attendedModal').on('hidden.bs.modal', function (e) {
			scanner.stop();	
		})
		
		//출석 여부 조회
		isAttended();

		$('#calendar').fullCalendar({
			defaultView: 'month',
			displayEventEnd: false,
			showNonCurrentDates: false,
			themeSystem:'bootstrap4',
			contentHeight: 'auto',
			eventLimit : true,
			viewRender: function(view, element) {
				// 달력이 그려질때마다 해당 월의 첫번째 1일을 SrchDate로 넘겨줌
				srchAttended(new Date(view.start._i));
			},
			eventClick: function(calEvent, jsEvent, view){
				//console.log(calEvent);
			}
		});
			
});

function getLocation() {
	  if (navigator.geolocation) { // GPS를 지원하면
	    navigator.geolocation.getCurrentPosition(function(position) {
	      alert(position.coords.latitude + ' ' + position.coords.longitude);
	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
	    alert('GPS를 지원하지 않습니다');
	  }
}
	

function attended(){
	$("#attendedModal").modal("show");
	startCamera();
}

function startCamera(){
	Instascan.Camera.getCameras().then(function (cameras) {
	    if (cameras.length > 1) { // 2 이상인 경우 후면 카메라 먼저 실행
	    	scanner.start(cameras[1]);
	    } else if(cameras.length > 0){ // 0 이상인 경우 
	    	scanner.start(cameras[0]);
	    }	else {
	      console.error('No cameras found.');
	    }
	  }).catch(function (e) {
	    console.error(e);
	  });	
}


function isAttended(){
	
	var data = {groupNum : '${groupVo.groupNum}'};
	var dataStr = JSON.stringify(data); 
	var result;
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/is/attended/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		result = data.isAttended;
		if(result){//등원 후 일때
			attendedStatus = true;
			$('#attendanceBtn').html('하원');
		}else{// 등원 전 일때
			attendedStatus = false;
			$('#attendanceBtn').html('등원');
		}
	});
}

function srchAttended(date){
	
	var data = {groupNum : '${groupVo.groupNum}',srchDate: date};
	var dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/srch/attended/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		var eventsList = [];
		data.attendedVoList.forEach(function(item){
			//AWS RDS 에서 sysdate로 저장하면 UTC로 저장되어짐 seoul 타임존 +9:00 해주어야함
			eventsList.push({
				  title: '등원',
			      start: moment(item.attendedIn).add(9,'hours'),
			      end: moment(item.attendedIn).add(9,'hours'),
			      backgroundColor: '#007bff',
			      borderColor: '#007bff',
			      textColor: '#fff'})
			
			if(item.attendedOut !== null){
				eventsList.push({
					  title: '하원',
				      start: moment(item.attendedOut).add(9,'hours'),
				      end: moment(item.attendedOut).add(9,'hours'),
				      backgroundColor: '#dc3545',
				      borderColor: '#dc3545',
				      textColor: '#fff'})	
			}
			  
		})
		$('#calendar').fullCalendar('removeEvents');
		$('#calendar').fullCalendar('addEventSource',eventsList);
		
	});
	
}
function attendedIn(qrCode){
	
	var data = {groupNum : '${groupVo.groupNum}',attendedQRCode : qrCode};
	var dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/attended/in/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		console.log(data);
		if(data.errC==="0000"){
			location.reload();
		}else if(data.errC === "E001"){
			//QR코드 불일치로 인한 실패
		}
	});
}
function attendedOut(qrCode){
	
	var data = {groupNum : '${groupVo.groupNum}',attendedQRCode : qrCode};
	var dataStr = JSON.stringify(data); 
	
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/attended/out/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		console.log(data);
		if(data.errC==="0000"){
			location.reload();
		}else if(data.errC === "E001"){
			//QR코드 불일치로 인한 실패
		}
	});
}
</script>
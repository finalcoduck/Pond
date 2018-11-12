<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">



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
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/gcal.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/vendor/fullcalendar/locale/ko.js" type="text/javascript"></script>

<script>

$(document).ready(function(){
		
		//출석 여부 조회
		isAttended();

		$('#calendar').fullCalendar({
			defaultView: 'month',
			displayEventEnd: false,
			showNonCurrentDates: false,
			themeSystem:'bootstrap4',
			contentHeight: 'auto',
			viewRender: function(view, element) {
				srchAttended(new Date(view.start._i));
			}
		});
		$('#calendar').fullCalendar('option', 'timezone', 'Asia/Seoul');
		$('#attendanceBtn').on('click',attendedIn);

		
});
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
			$('#attendanceBtn').html('하원');
		}else{// 등원 전 일때
			
		}
	});
}

function attended(){
	
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
		$('#calendar').fullCalendar('addEventSource',eventsList);
		console.log(eventsList);
	});
	
}
function attendedIn(){
	
	var data = {groupNum : '${groupVo.groupNum}'};
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
	});
}
</script>
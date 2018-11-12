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
			contentHeight: 'auto'
		});
		var events = [{
			  title: 'Event Title3',
		      start: '2018-11-17T13:13:55.008',
		      end: '2018-11-19T13:13:55.008',
		      backgroundColor: '#dc3545',
		      borderColor: '#dc3545',
		      textColor: '#fff'},
		      {
			      title: 'Event Title1',
			      start: '2018-03-17T13:13:55.008',
			      end: '2018-03-19T13:13:55.008',
			      backgroundColor: '#dc3545',
			      borderColor: '#dc3545',
			      textColor: '#fff'
			    },
			    {
			      title: 'Event Title2',
			      start: '2018-03-17T13:13:55-0400',
			      end: '2018-03-19T13:13:55-0400',
			      backgroundColor: '#007bff',
			      borderColor: '#007bff',
			      textColor: '#fff'
			    }
		      ];
		$('#calendar').fullCalendar('addEventSource',events);
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
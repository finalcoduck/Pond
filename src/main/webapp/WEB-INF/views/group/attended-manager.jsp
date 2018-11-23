<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">

<section id="main">
	
	<div class="container">
		<div class="row justify-content-center mt-3">
			<div class="col-12 col-md-8">
			</div>
			
			<div id="calendar" class="col-12 col-md-8 mb-3">
			</div>
			
			<div class="col-12 col-md-8 mb-3">
				<a id="attendanceBtn" href="${pageContext.request.contextPath }/group/attended/qrgenerator?groupNum=${groupVo.groupNum}" class="btn btn-primary btn-block">출석 모드</a>
			</div>		
		</div>
	</div>
</section>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath }/vendor/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/vendor/fullcalendar/gcal.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/vendor/fullcalendar/locale/ko.js" type="text/javascript"></script>

<script>

$(document).ready(function(){

		$('#calendar').fullCalendar({
			defaultView: 'month',
			displayEventEnd: false,
			displayEventStart: false,
			showNonCurrentDates: false,
			eventLimit : true,
			themeSystem:'bootstrap4',
			contentHeight: 'auto',
			viewRender: function(view, element) {
				// 달력이 그려질때마다 해당 월의 첫번째 1일을 SrchDate로 넘겨줌
				srchGroupAttended(new Date(view.start._i));
			},
			eventClick: function(calEvent, jsEvent, view){
				//console.log(calEvent);
			}
		});
			
});
	

function srchGroupAttended(date){
	
	var data = {groupNum : '${groupVo.groupNum}',srchDate: date};
	var dataStr = JSON.stringify(data); 
	
	$.ajax({
   		url : "${pageContext.request.contextPath}/group/srch/group-attended/proc"
		, method : "post"
   		, dataType : 'json'
   		, data : dataStr
   		, processData : true
   		, contentType : "application/json; charset=UTF-8"
	})
	.done(function(data){
		var eventsList = [];
		if(data.errC==="0000"){
			//AWS RDS 에서 sysdate로 저장하면 UTC로 저장되어짐 seoul 타임존 +9:00 해주어야함
			data.memNameAttendedDtoList.forEach(function(item){
				eventsList.push({
					  title: item.memName+' 등원',
				      start: moment(item.attendedIn).add(9,'hours'),
				      end: moment(item.attendedIn).add(9,'hours'),
				      backgroundColor: '#007bff',
				      borderColor: '#007bff',
				      textColor: '#fff'})
				
				if(item.attendedOut !== null){
					eventsList.push({
						  title: item.memName+' 하원',
					      start: moment(item.attendedOut).add(9,'hours'),
					      end: moment(item.attendedOut).add(9,'hours'),
					      backgroundColor: '#dc3545',
					      borderColor: '#dc3545',
					      textColor: '#fff'})	
				}
			});
			$('#calendar').fullCalendar('removeEvents');
			$('#calendar').fullCalendar('addEventSource',eventsList);
		}
	});
}

function makeAttendedEvent(eventObjectList, eventObjectKeys){
	var eventsList = [];
	var eventObjectKeysLength = eventObjectKeys.length;
	
	for(var i=0;i<eventObjectKeysLength;i++){
		
		if(eventObjectList[eventObjectKeys[i]].absenceCount !== 0){
			eventsList.push({
				title: '결석 '+eventObjectList[eventObjectKeys[i]].absenceCount+'명',
			    start: eventObjectKeys[i],
			    backgroundColor: '#007bff',
			    borderColor: '#007bff',
			    textColor: '#fff'
			});
		}
		if(eventObjectList[eventObjectKeys[i]].presentCount !== 0){
			eventsList.push({
				title: '수업중 '+eventObjectList[eventObjectKeys[i]].presentCount+'명',
			    start: eventObjectKeys[i],
			    backgroundColor: '#007bff',
			    borderColor: '#007bff',
			    textColor: '#fff'
			});
		}
		if(eventObjectList[eventObjectKeys[i]].leaveCount !== 0){
			eventsList.push({
				title: '하원 '+eventObjectList[eventObjectKeys[i]].leaveCount+'명',
			    start: eventObjectKeys[i],
			    backgroundColor: '#007bff',
			    borderColor: '#007bff',
			    textColor: '#fff'
			});
		}
	}
	return eventsList;
}
/* var eventObjectList = {};
var eventObjectKeys = [];
data.memNameAttendedDtoList.forEach(function(item){
	item.attendedIn = moment(item.attendedIn).add(9,'hours');
	if(item.attendedOut === ''){
		item.attendedOut = moment(item.attendedOut).add(9,'hours');	
	}
	item.attendedOut = moment(item.attendedOut).add(9,'hours');
	
	var eventDate = item.attendedIn.format('YYYYMMDD');
	
		//키목록에 없는 날짜면 키목록에 날짜 추가후 리스트에 이벤트 추가
		if(eventObjectKeys.indexOf(eventDate) === -1){
		eventObjectKeys.push(eventDate);
		eventObjectList[eventDate] = {absenceCount:0,presentCount:0,leaveCount:0};
	};
	
	if(item.attendedType==="A"){
		eventObjectList[eventDate].absenceCount++;
	}else if(item.attendedType==="P"){
		eventObjectList[eventDate].presentCount++;
	}else if(item.attendedType==="L"){
		eventObjectList[eventDate].leaveCount++;
	}
	
});
console.log(eventObjectList);
console.log(eventObjectKeys);
console.log(makeAttendedEvent(eventObjectList,eventObjectKeys));
$('#calendar').fullCalendar('removeEvents');
$('#calendar').fullCalendar('addEventSource',makeAttendedEvent(eventObjectList,eventObjectKeys)); */
</script>
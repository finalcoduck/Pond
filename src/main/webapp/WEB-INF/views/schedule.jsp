<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#calendar {
  max-width: 800px;
  margin: 0 auto;
}	
.fc-sun{
	color:red;
}
.fc-sat{
	color:blue;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<link href="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
		<div id='calendar'></div>
		<button type="button" id="addCal" class="btn">일정 등록</button>
	</div>
	<div class="row" id="testRow">
		
	</div>	
</div>
</body>
<script type="text/javascript">
$('#addCal').click(function() {
	location.href="${pageContext.request.contextPath}/schedule/addCal";
});

//replaceAll 메소드 만들기
String.prototype.replaceAll = function (org, dest) {
	return this.split(org).join(dest);
}

var colorList = ['#FE2EF7','#FF0040','#9F81F7','#58FA58','#FF8000'];
$(function() {
	  getInfo_Month(18, 10);
	  // page is now ready, initialize the calendar...
	  $('#calendar').fullCalendar({
		  displayEventEnd: false,
		  showNonCurrentDates: false,
		  fixedWeekCount: false,
		  themeSystem:'bootstrap4',
		  bootstrapFontAwesome :
		  {
			  close: 'fa-times',
			  prev: 'fa-hand-point-left',
			  next: 'fa-hand-point-right',
			  prevYear: 'fa-angle-double-left',
			  nextYear: 'fa-angle-double-right'
		  },
		  header:
		  {
		  left : 'prevYear prev',
		  center: 'title',
		  right: 'today next nextYear'
		  },
		  dayClick: function(event) {
		        console.log(event.target);
		    },
		    
		    customButtons:{
		    	myCustomButton:{
		    		text:'일정입력',
		    		click: function(event){
		    			onSelectEvent(event);
		    		}
		    	}
		    },
	    // put your options and callbacks here
	     events: [
	    	 <c:forEach var="vo" items="${list}" varStatus="status">
               {
                   title: "${vo.scheduleTitle}",
                   start: "${vo.scheduleStartDate}",
                   end: "${vo.scheduleEndDate}",
               	   backgroundColor: colorList[${status.index%5}],
               	   textColor: "black",
               	   num: "${vo.scheduleNum}"
               }, 
             </c:forEach>  
            ],
         eventClick:function(event){
        	 if(confirm('수정하시겠습니까?')){
        		 var num = event.num;
        		 var start = event.start;
        		 console.log(typeof(start));
        		 debugger;
        		 var end = event.end;
        		 
        		 updateSchedule(num, start, end);
        	 }
         },
         eventMouseover:function(calEvent,jsEvent){
			$(this).css('background-color','black').css('cursor','pointer').css('color','white');
         },
         eventMouseout:function(calEvent,jsEvent){
 			$(this).css('background-color',calEvent.backgroundColor).css('color','black');	
          }
	  });
		// 이전,다음 버튼을 누를 때 실행되는 메소드
		$('button.fc-prev-button, .fc-next-button').click(function() {
			var dd = $('#calendar').fullCalendar("getDate");
			var date = new Date(dd);
			var month = date.getMonth() + 1;
			var year = date.getYear() - 100;
			getInfo_Month(year, month);
		});
	});
	
	function convertDate(date) {
		var date = new Date(date);
		return date.getMonth();
	}
	
	//이전,다음 버튼을 눌렀을때 해당 년 월에 해당하는 정보를 가져오는 메소드
	function getInfo_Month(year, month) {
		$('#testRow').empty();
		$.ajax({
			url : "<c:url value='/schedule/getInfo'/>",
			dataType : 'json',
			type : 'post',
			data : {'year':year, 'month':month, 'groupNum':30},
			success: function(data) {
				var html = "";
				$.each(data.result_list, function(i, vo) {
					html += $('#template-list-item').html().replace("{title}", vo.scheduleTitle)
														   .replace("{content}", vo.scheduleContent)
														   .replaceAll("{start}", vo.scheduleStartDate)
														   .replaceAll("{end}", vo.scheduleEndDate)
														   .replaceAll("{num}", vo.scheduleNum);
				});
				$('#testRow').append(html);
			}
		});
	}
	
	//ajax 일정 삭제 메소드
	function deleteSchedule(num, start) {
		var ok = window.confirm("정말로 삭제 하시겠습니까?");
		if(ok){
			$.ajax({
				url : "${pageContext.request.contextPath}/schedule/delete",
				dataType : 'json',
				type : 'post',
				data : {'scheduleNum' : num, 'scheduleStartDate' : start},
				success: function(data) {
					if(data.msg === 'true'){
						getInfo_Month(data.year, data.month);
						location.href="${pageContext.request.contextPath}/schedule/info?groupNum=${list[0].groupNum}";
					}else{
						alert('삭제실패');	
					}
				}
			});
		}else{
			return false;
		}
	}
	
	function updateSchedule(num, start, end){
		location.href="${pageContext.request.contextPath}/schedule/updatepage?num="+num+"&start="+start+"&end="+end;
	};
</script>
<script type="text/template" id="template-list-item">
<div style="border: 1px solid black; width: 100%; height: 30%;" id="calbox">
		<span>{title}</span><br> 
		<span>{content}</span><br>
		<span>{start} ~ {end}</span>
		<button type="button" onclick="deleteSchedule({num},'{start}')">일정삭제</button>
		<button type="button" onclick="updateSchedule({num},'{start}','{end}')">일정수정</button>
</div>
</script>
</html>



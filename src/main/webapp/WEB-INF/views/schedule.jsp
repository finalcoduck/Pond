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
<link href="<c:url value='/resources/build/css/fullcalendar.min.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/build/js/fullcalendar.min.js'/>" type="text/javascript"></script>
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

var colorList = ['blue','black','red','green','pink'];
$(function() {
	  // page is now ready, initialize the calendar...
	  $('#calendar').fullCalendar({
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
               	   backgroundColor: colorList[${status.index}],
               	   textColor: "white"
               }, 
             </c:forEach>  
            ],
         eventClick:function(event){
        	 
         }   
	  });
		// 이전,다음 버튼을 누를 때 실행되는 메소드
		$('button.fc-prev-button').click(function() {
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
	
	function getInfo_Month(year, month) {
		$.ajax({
			url : "<c:url value='/schedule/getInfo'/>",
			dataType : 'json',
			type : 'post',
			data : {'year':year, 'month':month},
			success: function(data) {
				/* $('#calbox').children().eq(0).text(data.result_list[0].scheduleTitle); */
				var html = "";
				$.each(data.result_list, function(i, vo) {
					html += $('#template-list-item').html().replace("{title}", vo.scheduleTitle)
														   .replace("{content}", vo.scheduleContent)
														   .replace("{start}", vo.scheduleStartDate)
														   .replace("{end}", vo.scheduleEndDate);
				});
				$('#testRow').append(html);
			}
		});
	}
</script>
<script type="text/template" id="template-list-item">
<div style="border: 1px solid black; width: 100%; height: 30%;" id="calbox">
		<span>{title}</span><br> 
		<span>{content}</span><br>
		<span>{start} ~ {end}</span>
</div>
</script>
</html>



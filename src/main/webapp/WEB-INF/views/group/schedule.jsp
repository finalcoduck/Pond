<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<link href="<c:url value='/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">
<link href="<c:url value='/build/css/group.css'/>" rel="stylesheet">
<script src="<c:url value='/vendor/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/vendor/fullcalendar/gcal.js'/>" type="text/javascript"></script>
<div class="container mt20">
	<div>
		<div id='calendar'></div>
	<div class="align_c mt20">
		<c:if test="${status == 'M'.charAt(0) }">
		  <button type="button" id="addCal" class="btn btn-success">일정 등록</button>
		</c:if>
		</div>
	</div>
	<div id="testRow">
		
	</div>	
</div>
<script type="text/javascript">
$('#addCal').click(function() {
	location.href="${pageContext.request.contextPath}/schedule/add-cal?groupNum=${groupNum}";
});

//replaceAll 메소드 만들기
String.prototype.replaceAll = function (org, dest) {
	return this.split(org).join(dest);
}

var colorList = ['#2ECCFA','#D358F7','#01DFA5','#58FA58','#FF8000'];
$(function() {
	  var calYear = new Date().getFullYear();
	  var calMonth = new Date().getMonth()+1;
	  
	  calYear -= 2000;
	  if(calMonth<10){
		  calMonth = "0"+calMonth;
	  }
	  console.log(calMonth);
	  getInfo_Month(calYear, calMonth);
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
		  lang : "ko",
		  editable : true,
		  eventLimit : true,
	      googleCalendarApiKey : "AIzaSyBBmL-30gox_ec9v4QY-TTKY2Dsif7NxBg"
	        ,dayClick: function(event) {
		        console.log(event.target);
		    },
		    customButtons:{
		    	myCustomButton:{
		    		text:'일정입력',
		    		click: function(event){
		    			onSelectEvent(event);
		    		}
		    	}
		    }
	     ,
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
            ] ,
            <c:if test="${status == 'M'.charAt(0) }">
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
         </c:if>
         eventMouseover:function(calEvent,jsEvent){
			$(this).css('background-color','black').css('cursor','pointer').css('color','white');
         },
         eventMouseout:function(calEvent,jsEvent){
 			$(this).css('background-color',calEvent.backgroundColor).css('color','black');	
          }
	  });
		// 이전,다음 버튼을 누를 때 실행되는 메소드
		$('button.fc-prev-button, .fc-next-button, .fc-today-button').click(function() {
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
			data : {'year':year, 'month':month, 'groupNum':${groupNum} },
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
<div class="card_wrap" id="calbox">
	<div class="cal_card">
		<span class="cal_tit">{title}</span>
		<span class="cal_con">{content}</span>
		<span class="cal_date">{start} ~ {end}</span>
	</div>
	<div class="btn_wrap">
		<c:if test="${status == 'M'.charAt(0) }">
		<button type="button" class="btn" onclick="deleteSchedule({num},'{start}')">일정삭제</button>
		<button type="button" class="btn btn-info" onclick="updateSchedule({num},'{start}','{end}')">일정수정</button>
		</c:if>
	</div>
</div>
</script>
</html>



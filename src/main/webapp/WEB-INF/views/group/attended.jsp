<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.css'/>" rel="stylesheet">



<section id="main">
	<div class="container">
		<div id="row justify-content-center">
			<div class="col-12 col-md-8">
				<div id="calendar" >
				</div>
			</div>	
		</div>
		<div class="col-12 col-md-8">
				<button class="btn btn-primary btn-block">출석</button>
			</div>
	</div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="<c:url value='/resources/vendor/fullcalendar/fullcalendar.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/vendor/fullcalendar/gcal.js'/>" type="text/javascript"></script>

<script>
$(document).ready(function(){
		$('#calendar').fullCalendar({
			defaultView: 'month'
		});		
});
</script>
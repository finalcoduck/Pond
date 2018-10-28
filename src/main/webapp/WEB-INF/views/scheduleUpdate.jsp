<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ㅎㅇㅎㅇ</h1>
	<form action="${pageContext.request.contextPath }/schedule/updatepage" method="post">
	스케줄 이름 : <input type="text" value="${vo.scheduleTitle }" name="scheduleTitle"/><br>	
	스케줄 내용 : <input type="text" value="${vo.scheduleContent }" name="scheduleContent"/><br>
	시작 날짜: <input type="date" value="${start }" name="scheduleStartDate"/><br>
	종료 날짜: <input type="date" value="${end }" name="scheduleEndDate"/><br>
	<input type="hidden" value="${vo.scheduleNum }" name="scheduleNum" />
	<input type="submit" value="수정" />
	</form>
</body>
</html>
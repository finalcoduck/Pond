<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>일정 등록</h1>

<form action="${pageContext.request.contextPath}/schedule/add-cal" method="post">
	일정 제목 : <input type="text" name="scheduleTitle" /><br>
	일정 내용 : <textarea rows="5" cols="30" name="scheduleContent"></textarea><br>
	시작 날짜 : <input type="date" name="scheduleStartDate"/><br>
	끝 날짜 : <input type="date" name="scheduleEndDate" /><br>
	<input type="hidden" name="groupNum" value="${groupNum }" /><br>
	<input type="submit" value="등록" />
</form>
</body>
</html>
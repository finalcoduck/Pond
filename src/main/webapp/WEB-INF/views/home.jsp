<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<c:if test="${!empty loginFail }">
<script type="text/javascript">alert('${loginFail}');</script>
</c:if>
<body>
	<h1>Hello world~</h1>
	
	<a href="${pageContext.request.contextPath }/member/main/loginForm">로그인</a>
	
	<h3>세션확인용</h3>
	<h4>${sessionScope.memVo.memId }</h4>
	<h4>${sessionScope.memVo.memEmail }</h4>
	
	<a href="<c:url value='/member/main/logout'/>">로그아웃</a>
	
	<a href="<c:url value='/group/test'/>">테스트</a>
	
	<a href="<c:url value='/schedule/info?groupNum=30'/>">일정관리</a>
</body>
</html>
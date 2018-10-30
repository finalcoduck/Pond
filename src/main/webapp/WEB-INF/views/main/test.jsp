<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="">
	<h1>로그인 후 확인</h1>
	${memDto.memVo.memEmail }<br>
	<c:forEach items="${memDto.keySet }" var="key">
		${key }<br>
	</c:forEach>
	<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath }/member/profile">내정보 보기</a>	
</section>
</html>
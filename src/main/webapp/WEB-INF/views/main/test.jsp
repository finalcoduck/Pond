<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="">
	<h1>로그인 후 확인</h1>
	${memVo.memEmail }<br>
	<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath }/member/profile">내정보 보기</a>	
</section>
</html>
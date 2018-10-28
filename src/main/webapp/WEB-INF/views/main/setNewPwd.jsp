<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>새로운 비밀번호 설정</h1>
<form action="${pageContext.request.contextPath }/member/login/changePwd" method="post">
	<input type="hidden" name="email" value=${email }>
	<input type="password" name="newPwd"/><br>
	<input type="password" name="newPwd2" /><br>
	<input type="submit" value="확인" />
</form>
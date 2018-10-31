<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<h1>이메일 인증을 해주세요</h1>
	<a href="${pageContext.request.contextPath }/">메인 화면</a>
	<span id="sp-count">5</span>
</body>
<script type="text/javascript">
$(function(){
	lets();
	var n = 5;
	function lets(){
		if(n == 0){
			window.location.href="${pageContext.request.contextPath}/";
		}
		$('#sp-count').text(n);
		n = n-1;
		timerId = setTimeout(lets, 1000);
	}
})
</script>

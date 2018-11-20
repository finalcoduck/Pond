<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%
    String clientId = "cXnG4ZMsAU0UT9_rvvIe";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8090/pond/login/navercallback", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
	session.setAttribute("state", state);
%>     
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/login_style.css">
    
<section id="" class="bg-primary">
<c:if test="${!empty changePwdMsg}"><script type="text/javascript">
swal({
	type : 'success',
	title : '비밀번호 변경 성공!',
	showConfirmButton: true,
	timer : 1500,
})</script></c:if>
<c:if test="${!empty loginFail }"><script type="text/javascript">
swal({
	type : 'error',
	title : '이메일 혹은 비밀번호를 확인해주세요.',
	showConfirmButton: true,
	timer : 1500,
})</script></c:if>
<c:if test="${!empty dpMsg }"><script type="text/javascript">
swal({
	type : 'error',
	title : '이미 가입된 이메일 입니다.',
	showConfirmButton: true,
	timer : 1500,
})
</script></c:if>
<c:if test="${!empty changeMsg }"><script type="text/javascript">
swal({
	type : 'success',
	title : '새로운 비밀번호로 변경되었습니다.',
	showConfirmButton: true,
	timer : 1500,
})</script></c:if>
        <div class="container">
            <div class="row align-items-center">
                <div class="mt-5col-12 col-md-6">
                    <h2 class="text-white">오직</h2>
                    <h2 class="text-white">학원을 위한 커뮤니티</h2>
                    <p class="lead text-white">출결 관리, 공지, 학원생들을 위한 커뮤니티 지원</p>
                </div>
                <div class="col-12 col-md-6 justify-content-center">
                    <form class="justify-content-center" action="${pageContext.request.contextPath }/login/normal" method="post">
                        <svg id="ryan" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
                            <path d="M0,150 C0,65 120,65 120,150" fill="#ffcb01" stroke="#000" stroke-width="2" />
                            <circle cx="60" cy="60" r="40" fill="#ffcb01" stroke="#000" stroke-width="2" />
                            <g class="eyes">
                                <!-- 왼쪽 눈과 눈썹-->
                                <ellipse cx="42" cy="57" rx="7" ry="8" fill="#000" />
                                <ellipse cx="43" cy="55" rx="1.5" ry="2" fill="#fff" />
                                <!-- 오른쪽 눈과 눈썹 -->
                                <ellipse cx="78" cy="57" rx="7" ry="8" fill="#000" />
                                <ellipse cx="77" cy="55" rx="1.5" ry="2" fill="#fff" />
                            </g>
                            <g class="muzzle">
                                <path d="M40,79 C40,74.5 80,74.5 80,79" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                                <path d="M50,76 C60,69 60,69 70,76" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                                <path d="M40,79 C40,89 80,89 80,79" fill="#ff5402" stroke="#ff5402" stroke-width="1" />
                                <polygon points="62,72.5 62.5,73" fill="#000" stroke="#000" stroke-width="1"
                                    stroke-linejoin="round" />
                                <polygon points="58.5,72.5 58,73" fill="#000" stroke="#000" stroke-width="1"
                                    stroke-linejoin="round" />
                            </g>
                        </svg>
                        <input type="text" placeholder="email@domain.com" name="memEmail">
                        <input type="password" placeholder="Password" name="memPwd">
                        <input type="submit" class="btn btn-dark text-white" value="로그인">
                        <div class="align_c mt10">
                        	<a href="${pageContext.request.contextPath }/login/sendMail">비밀번호 찾기</a>
                        </div>
                        <img class="input-img cursor-pointer" src="${pageContext.request.contextPath}/build/image/btn_google_signin_light.png" alt="google login" onclick="location.href='${google_url}'">
                        <img class="input-img cursor-pointer" src="${pageContext.request.contextPath}/build/image/naver-green.PNG" alt="naver login" onclick="location.href='<%= apiURL %>'">
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-5">

                </div>
                <div class="col-12 col-md-5">

                </div>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/build/js/login_script.js"></script>
    <script>
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker
         .register('${pageContext.request.contextPath}/service-worker.js')
         .then(function() { 
            console.log('Service Worker Registered'); 
          });
      }
    </script> 

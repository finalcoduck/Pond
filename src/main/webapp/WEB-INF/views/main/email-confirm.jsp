<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link href='https://fonts.googleapis.com/css?family=Cabin+Condensed:700' rel='stylesheet' type='text/css'>
<style>
body {
  background: #2E64FE;
  text-align: center;
}
.water-fill {
  -webkit-animation: wave 0.7s infinite linear, fill-up 17s infinite ease-out alternate;
          animation: wave 0.7s infinite linear, fill-up 17s infinite ease-out alternate;
}
.loading{margin-top:-30px}
h1.chk_mail{font-size:50px; color:#fff; font-family:'Cabin Condensed'; margin-left:310px;}
@-webkit-keyframes wave {
  0% {
    x: -400px;
  }
  100% {
    x: 0;
  }
}
@keyframes wave {
  0% {
    x: -400px;
  }
  100% {
    x: 0;
  }
}
@-webkit-keyframes fill-up {
  0% {
    height: 0;
    y: 130px;
  }
  100% {
    height: 160px;
    y: -30px;
  }
}
@keyframes fill-up {
  0% {
    height: 0;
    y: 130px;
  }
  100% {
    height: 160px;
    y: -30px;
  }
}
</style>

<body>
<div style="margin-top: 200px; margin-left:-310px;">
	<h1 class="chk_mail">Please Check Mail</h1>
	<svg class="loading" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="-50px" y="0px"
		 width="1400px" height="120px" viewBox="0 0 574.558 120" enable-background="new 0 0 574.558 120" xml:space="preserve">
	  <defs>
	    <pattern id="water" width=".25" height="1.1" patternContentUnits="objectBoundingBox">
	      <path fill="#fff" d="M0.25,1H0c0,0,0-0.659,0-0.916c0.083-0.303,0.158,0.334,0.25,0C0.25,0.327,0.25,1,0.25,1z"/>
	    </pattern>
	    
	    <text id="text" transform="matrix(1 0 0 1 -8.0684 116.7852)" font-family="'Cabin Condensed'" font-size="80">Moves to main after 5 seconds</text>
	    
	    <mask id="text_mask">
	      <use x="0" y="0" xlink:href="#text" opacity="1" fill="#ffffff"/>
	    </mask>
	  </defs>
	 
		  <use x="0" y="0" xlink:href="#text" fill="#58D3F7"/>
	  
	  <rect class="water-fill" mask="url(#text_mask)" fill="url(#water)" x="-400" y="0" width="1600" height="120"/>
	</svg>
</div>
</body>
<script type="text/javascript">
$(function(){
	var n = 5;
	lets();
	function lets(){
		if(n == 0){
			window.location.href="${pageContext.request.contextPath}/";
		}
		$('#text').html("Moves to main after "+n+" seconds");
		n = n-1;
		timerId = setTimeout(lets, 1000);
	}
})
</script>

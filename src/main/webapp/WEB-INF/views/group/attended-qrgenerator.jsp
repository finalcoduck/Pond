<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="main">
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-6">
				
					
			</div>
			<div class="col-12 col-md-6">
				<div id="qrCode">
				</div>	
			</div>
		</div>
	</div>

</section>
<script src="${pageContext.request.contextPath }/resources/vendor/qrcodejs/qrcode.min.js" type="text/javascript"></script>
<script>

$(document).ready(function(){
	
	var qrcode = new QRCode(document.getElementById("qrCode"), {
	    text: "http://jindo.dev.naver.com/collie",
	    width: 128,
	    height: 128,
	    colorDark : "#000000",
	    colorLight : "#ffffff",
	    correctLevel : QRCode.CorrectLevel.H
	});

});

</script>
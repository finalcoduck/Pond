<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#info {
	background-color : #b1cbe5;
}

.actionTxtType3 {
	 padding:76px 0;
	 text-align:center;
}
.actionTxtType3 .view_tit{
	 padding-bottom:15px;
	 font-size:35px;
	 line-height:35px;
	 text-transform:uppercase;
	 font-weight:700;
	text-shadow:1px 1px 10px rgba(68,68,68,0.4);
	 opacity:0;
	 transform:translateY(30%);
	 -webkit-transform:translateY(30%);
	 -moz-transform:translateY(30%);
	 -ms-transform:translateY(30%);
	 transition:all .35s;
	 -webkit-transition:all .35s;
	 -moz-transition:all .35s;
}
.actionTxtType3 .line_bg {
	 width:16%;
	 height:5px;
	 background-color:#e09738;
	 margin:0 auto;
	 margin-bottom:20px;
	opacity:0;
	transform:scaleX(0);
	-webkit-transform:scaleX(0);
	-moz-transform:scaleX(0);
	-ms-transform:scaleX(0);
	transition:transform .25s .35s,opacity .2s;
	 -webkit-transition:-webkit-transform .25s .35s,opacity .2s;
	 -moz-transition:-moz-transform .25s .35s,opacity .2s;
}
.actionTxtType3 .view_txt {
	 opacity:0;
	 transform:translateY(30%);
	 -webkit-transform:translateY(30%);
	 -moz-transform:translateY(30%);
	 transition:all .35s .6s;
	 -webkit-transition:all .35s .6s;
	 -moz-transition:all .35s .6s;
}
.actionTxtType3:hover .view_tit{
	 opacity:1;
	 transform:translateY(0);
	 -webkit-transform:translateY(0);
	 -moz-transform:translateY(0);
	 -ms-transform:translateY(0);
}
.actionTxtType3:hover .line_bg{
	 opacity:1;
	 transform:scaleX(1);
	 -webkit-transform:scaleX(1);
	 -moz-transform:scaleX(1);
	 -ms-transform:scaleX(1);
}
.actionTxtType3:hover .view_txt{
	 opacity:1;
	 transform:translateY(0);
	 -webkit-transform:translateY(0);
	 -moz-transform:translateY(0);
	 -ms-transform:translateY(0);
}
</style>

<section id="main">
	<div class="container mt-5 ">
		<div class="row vh80 align-items-center">
			<div class="col-12 col-md-6">
				<div class="txt_view actionTxtType3">
					<div class="view_tit">${groupVo.groupName}</div>
					<div class="line_bg"></div>
					<div class="view_txt">${groupVo.groupDescription}</div>
				</div>
			</div>
			<div class="col-12 col-md-6">
				<div class="text-center align-items-center">
					<img class="w-50" src="${pageContext.request.contextPath}/upload/group-photo/${groupVo.groupImage}" alt="">
				</div>
			</div>
		</div>
	</div>
</section>
<section id="info">
	<div class="container ">
		<div class="row pb-5 justify-content-around">
			<div class="col-12 col-md-3 my-4 mx-3 text-center bg-white shadow">
				<h6 class="text-black-40 text-uppercase mt-3">전화번호</h6>
				<i class="my-5 fas fa-phone fa-5x" style="color: #339af0;"></i>

				<h5 class="text-black-40 text-uppercase mb-3">${groupVo.groupPhoneNum}</h5>
			</div>

			<div class="col-12 col-md-3 my-4 mx-3 text-center bg-white shadow">
				<h6 class="text-black-40 text-uppercase mt-3">주소</h6>
				<i class="my-5 fas fa-map-marked-alt fa-5x" style="color: #339af0;"></i>

				<h5 class="text-black-40 text-uppercase mb-3">${groupVo.groupAddr}</h5>
			</div>

		</div>
	</div>
</section>

<!-- content -->


<script>

$(document).ready(function(){

})
</script>
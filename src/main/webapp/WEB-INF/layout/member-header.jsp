<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<header	class="group-header bg-primary">
	<div class="inner">
		<nav class="navbar">
			<h1>
				<a href="${pageContext.request.contextPath }/">
					<b class="text-white">POND</b>
				</a>
			</h1>
			<div class="dropdown">
				<button class="btn" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<c:choose>
						<c:when test="${memDto.memVo.memProfilePic == null}">
							<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/build/image/img1.jpg" alt="">	
						</c:when>
						<c:otherwise>
						<!-- url 이미지 주소일때와 서버에 저장한 이미지 파일인 경우 -->
							<img class="rounded-circle profile-img" src="${memDto.memVo.memProfilePic }" alt="">
							<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/upload/group-photo/img1.jpg" alt="">
							<%-- <img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/upload/mem-photo/${memDto.memVo.memProfilePic }" alt=""> --%>	
						</c:otherwise>			
					</c:choose>
				</button>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/profile">마이페이지</a>
					<a class="dropdown-item cursor-pointer" id="inviteCodeInput">초대코드 입력</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
				</div>
			</div>
		</nav>
	</div>
</header>
<script type="text/javascript">
	$('#inviteCodeInput').on('click',function(){
		swal({
			title : '초대코드 입력',
			input : 'text',
			inputAttributes: {
				autocapitalize : 'off'
			},
			showCancelButton: true,
			confirmButtonText: '발송',
			showLoaderOnConfirm: true,
			preConfirm:(inviteCode) => {
				location.href = "${pageContext.request.contextPath}/group/invite/input?inviteCode="+inviteCode;
			},
			allowOutsideClick: () => !swql.isLoading(),
			width : 640,
			padding: '3em',
			background: '#fff',
		    backdrop: `
				rgba(0,0,123,0.4)
			    url("${pageContext.request.contextPath}/resources/build/image/bbo1.gif")
			    center top
			    no-repeat
			  `
		})
	})
</script>
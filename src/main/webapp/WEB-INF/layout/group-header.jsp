<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/group.css"> 
	<header class="group-header">
        <nav class="navbar d-flex justify-content-between navbar-expand bg-primary shadow vh7">
            <h1>
                <a class=" text-white" href="${pageContext.request.contextPath }/">
                    <b>POND</b>
                </a>
            </h1>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath }/group/group-main?groupNum=${groupVo.groupNum}" style="font-size:20px;">스트림</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath }/group/member?groupNum=${groupVo.groupNum}" style="font-size:20px;">사용자</a>
                </li>
            </ul>
            <div class="mr-2">
                <button class="btn" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<!-- url 이미지 주소일때와 서버에 저장한 이미지 파일인 경우 -->
							<img class="rounded-circle nav-profile-img" src="${pageContext.request.contextPath }/upload/mem-photo/${memDto.memVo.memProfilePic }" alt="">	
                </button>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/profile">마이페이지</a>
					<a class="dropdown-item cursor-pointer" id="inviteCodeInput">초대코드 입력</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
				</div>                
            </div>
        </nav>
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
		confirmButtonText: '입력',
		cancelButtonText: '취소',
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
		    url("${pageContext.request.contextPath}/build/image/loverduck.gif")
		    center top
		    repeat
		  `
	})
})
</script>
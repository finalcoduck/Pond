<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/group.css"> 
	<header class="group-header">
        <nav class="navbar d-flex justify-content-between navbar-expand bg-primary">
            <h1>
                <a class=" text-white" href="${pageContext.request.contextPath }/">
                    <b>POND</b>
                </a>
            </h1>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-white" href="">스트림</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath }/group/member?groupNum=${groupVo.groupNum}">사용자</a>
                </li>
            </ul>
            <div class="mr-2">
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
					<a class="dropdown-item" href="#">초대코드 입력</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
				</div>                
            </div>
        </nav>
    </header>
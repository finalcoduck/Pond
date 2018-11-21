<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
	    <nav class="shadow navbar text-white text-uppercase justify-content-between vh7" style="background-color:rgba(0,0,255,0.4) !important;">
	        <h1>
	            <a class="text-white" href="${pageContext.request.contextPath}/group/group-main?groupNum=${groupVo.groupNum}">
	                <i class="fas fa-arrow-left"></i>
	            </a>
	        </h1>
	        <h5>상세보기</h5>
	        <ul class="navbar-nav">
	            <li id="detailSettingBtn" class="nav-item"><i class="fas fa-cog"></i> <a class="text-white" href="${pageContext.request.contextPath }/group/detail/setting?groupNum=${groupVo.groupNum}">설정</a></li>
	        </ul>
	    </nav>
    </header>
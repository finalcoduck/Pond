<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
	    <nav class="shadow navbar bg-primary text-white text-uppercase justify-content-between vh5 mb-3">
	        <h1>
	            <a class="text-white" href="${pageContext.request.contextPath}/group/group-main?groupNum=${groupVo.groupNum}">
	                <i class="fas fa-arrow-left"></i>
	            </a>
	        </h1>
	        <h5>상세보기</h5>
	        <ul class="navbar-nav">
	            <li id="detailSettingBtn" class="nav-item"></li>
	        </ul>
	    </nav>
    </header>
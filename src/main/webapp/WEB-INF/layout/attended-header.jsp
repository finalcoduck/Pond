<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header>
	    <nav class="shadow navbar bg-primary text-white text-uppercase justify-content-between vh7 mb-3">
	        <h1>
	            <a class="text-white" href="${pageContext.request.contextPath}/group/group-main?groupNum=${groupVo.groupNum}">
	                <i class="fas fa-arrow-left"></i>
	            </a>
	        </h1>
	        <h5>출석</h5>
	        <ul class="navbar-nav">
	            <li class="nav-item"><i class="fas fa-cog"></i> <a class="text-white" href="${pageContext.request.contextPath }/join">설정</a></li>
	        </ul>
	    </nav>
    </header>
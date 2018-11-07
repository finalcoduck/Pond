<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/build/css/crc_style.css">
		<link href="https://fonts.googleapis.com/css?family=Yellowtail" rel="stylesheet">
    <body>
       <div class="cover">
       	<h1 class="cover-title">
       		Curriculum
       		
       	</h1>
       </div>
       
       <div class="wrapper">
       		<a href="${pageContext.request.contextPath }/group/addPage?groupNum=${groupNum}">일정등록</a>
	       <ul class="timeline">
	       <c:forEach items="${list }" var="vo">
	       	<li class="timeline-item">
	       		<div class="card">
					<img src="${pageContext.request.contextPath }/resources/build/image/images/1.png" alt="" class="card-icon" />
					<h2 class="card-title">
						<div><fmt:formatDate value="${vo.crcStartDate }" pattern="yy/MM/dd"/> ~ <fmt:formatDate value="${vo.crcEndDate }" pattern="MM/dd"/></div>
					</h2>
					<dl class="card-definition">
						<dt>
							${vo.crcTitle }
							<span>${vo.crcTeacher }</span>
						</dt>
						<dd>${vo.crcContent }</dd>
					<dd>
			       		<i class="fas fa-edit crcUpdate" onclick="location.href='${pageContext.request.contextPath}/group/crc-update-page?crcNum=${vo.crcNum }'"></i>
			       		<i class="fas fa-trash-alt crcDelete" onclick="location.href='${pageContext.request.contextPath}/group/crc-delete?crcNum=${vo.crcNum }&groupNum=${vo.groupNum }'"></i>
		       		</dd>
					</dl>	       		
	       		</div>
	       	</li>
	       	</c:forEach>
	       </ul> 	
       </div>
    </body>
    <script type="text/javascript">
    	$('.crcUpdate').css('cursor','Pointer');
    	$('.crcDelete').css('cursor','Pointer');
    </script>

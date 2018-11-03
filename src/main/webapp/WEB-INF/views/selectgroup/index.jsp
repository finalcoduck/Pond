<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <style type="text/css">
		*, a{color:#333;}
		.group-list li.group-make span{
			background-image:url(${pageContext.request.contextPath}/resources/build/image/ico_plus.png);
		}
	</style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/group.css">

<section class="content group-wrap">
		<div class="inner">
			<h2	class="sub_title">내	그룹 <span class="num">${fn:length(groupList) }</span></h2>
			<ul	class="group-list mt20">
				<li class="group-make">
					<a href="${pageContext.request.contextPath }/selectgroup/insert-group">
						<span>그룹 만들기</span>
					</a>
				</li>
				
				<c:forEach var = "groupVo" items='${groupList}' varStatus="status">
				<li class="group">
					<a href="${pageContext.request.contextPath}/group/group-main?groupNum=${groupVo.groupNum}">
						<span class="wrapper">
							<img src="${pageContext.request.contextPath}/resources/upload/group-photo/${groupVo.groupImage}" alt="" style="width: 100%; height: 100%;"/>
						</span>
						<span class="info">
							<span class="group_name">
								${groupVo.groupName} 
								<c:if test="${groupVo.status == 'M'.charAt(0)}"><span style="color:red;">매니저</span></c:if>
								<c:if test="${groupVo.status == 'S'.charAt(0)}"><span style="color:blue;">학생</span></c:if>
							</span>
							<span class="num">
								멤버 ${groupVo.groupMemNum }명
							</span>
						</span>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
	</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <style type="text/css">
		*, a{color:#333;}
		.group-list li.group-make span{
			background-image:url(${pageContext.request.contextPath}/build/image/ico_plus.png);
		}
	</style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/group.css">

<c:if test="${!empty msg }"><script type="text/javascript">
swal({
	type : 'error',
	title : '유효하지 않은 코드 입니다.',
	showConfirmButton: true,
	timer : 1500,
})
</script></c:if> <!-- 그룹에 이미 가입한 회원 -->
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
							<img src="${pageContext.request.contextPath}/upload/group-photo/${groupVo.groupImage}" alt="" style="width: 100%; height: 100%;"/>
						</span>
						<span class="info">
							<span class="group_name">
								${groupVo.groupName} 
							</span>						
							<span class="num">
								멤버 ${groupVo.groupMemNum }명
							</span>
							<c:if test="${groupVo.status == 'M'.charAt(0)}">
								<span class="badge badge-pill badge-danger grade">매니저</span>
							</c:if>
							<c:if test="${groupVo.status == 'S'.charAt(0)}">
								<span class="badge badge-pill badge-success grade">학생</span>
							</c:if>	
						</span>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
	</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/build/css/group.css?ver=3">
<style>
#view_student .card .homework .file_list .wrapper .thumbnail:after{
	background-color: transparent;
}
#view_student .card .homework .file_list .wrapper .thumbnail img{
	top:50%; left:50%;
	transform:translate(-50%, -50%);
}
</style>    
	<section id="view_student" class="mt30">
		<h2>파일 모음</h2>
		<div class="card">
			<div class="card-body homework">
				<div class="homework_con">
					<div class="file_wrap">
						<c:if test="${empty fileList }">
							<h2>파일이 존재하지 않습니다.</h2>
						</c:if>
						<c:forEach items="${fileList }" var="vo">
						<div class="file_list">
							<div class="wrapper">
								<div class="thumbnail">
									<img src="${pageContext.request.contextPath }/resources/build/image/filetype/${vo.fileType }.png" alt=""
									style="">
								</div>
							</div>
							<div class="file_name">
								<p>${vo.orgFileName }</p>
								<span>${vo.fileSize }MB  <fmt:formatDate value="${vo.boardRegdate }" pattern="yyyy년MM월"/>  ${vo.boardWriter }
								<br><a href="#">원글 보기</a></span>
							</div>
							<button type="button">
								<i class="fas fa-cloud-download-alt" onclick="location.href='${pageContext.request.contextPath}/group/filedownload?saveFileName=${vo.saveFileName }&orgFileName=${vo.orgFileName }'"></i>
							</button>
						</div>
						</c:forEach>
					</div>
					<div class="btn_wrap">
					</div>
				</div>
			</div>
		</div>
	</section>

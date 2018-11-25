<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/quill/quill.snow.css">
<section id="view_student">
	<div class="card mb-3 mt20 shadow" id="before">
		<div class="card-header">
			<div class="d-flex justify-content-between align-items-center">
				<div class="d-flex justify-content-between align-items-center">
					<div class="mr-2">
						<img class="rounded-circle profile-img" src="https://picsum.photos/50/50" alt="">
					</div>
					<div class="ml-2">
						<div class="h5 m-0"  onclick="console.log($('body').hasScrollBar())">
							${hwSubmitDto.memName }
						</div>
						<div class="h7 text-muted">
							<fmt:formatDate value="${hwSubmitDto.boardRegdate }" pattern="yyyy년 MM월 dd일"/>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body homework">
			<h5 class="card-title">${hwSubmitDto.boardTitle }</h5>
			<p>${hwSubmitDto.boardContent }</p>
			<div class="homework_con">
				<div id=submitContent style="border:1px solid #ccc; padding:15px; margin-top:20px;">
					
				</div>
				<div class="file_wrap">
					<div class="file_list">
						<div class="wrapper">
							<div class="thumbnail">
								<img src="../build/image/img1.jpg" alt="">
							</div>
						</div>
						<div class="file_name">
							<p>img3.jpg</p>
							<span>이미지</span>
						</div>
						<button type="button">
							<i class="fas fa-cloud-download-alt" onclick=""></i>
						</button>
					</div>
					<div class="file_list">
						<div class="wrapper">
							<div class="thumbnail">
								
							</div>
						</div>
						<div class="file_name">
							<p>text.txt</p>
							<span>텍스트</span>
						</div>
						<button type="button">
							<i class="fas fa-cloud-download-alt" onclick=""></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script src="${pageContext.request.contextPath}/vendor/quill/quill.min.js"></script>
<script>
	$(document).ready(function(){
		var test = ${hwSubmitDto.hwSubmitContent };
		var submitContent = quillGetHTML(test);
		var div = document.getElementById("submitContent");
		div.innerHTML = submitContent;
	});
</script>
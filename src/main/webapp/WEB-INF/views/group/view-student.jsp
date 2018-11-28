<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<div class="h5 m-0"  onclick="console.log($('body').hasScrollBar())">강덕영</div>
						<div class="h7 text-muted">10월 12일</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body homework">
			<form id="submitForm" action="${pageContext.request.contextPath}/board/submit/homework" method="post">
				<input type="hidden" name="boardNum" value="${hwBoardVo.boardNum }">
				<input type="hidden" value="${groupNum }" name="groupNum">
				<h5 class="card-title">${hwBoardVo.boardTitle }</h5>
				<p>${hwBoardVo.boardContent }</p>
				<div class="homework_con">
					<c:choose>
						<c:when test="${hwSubmitVo.hwSubmit == 'B'.charAt(0) }">
							<span class="status before">할당됨</span>
						</c:when>
						<c:when test="${hwSubmitVo.hwSubmit == 'P'.charAt(0) }">
							<span class="status propose">제출함</span>
						</c:when>
						<c:when test="${hwSubmitVo.hwSubmit == 'C'.charAt(0) }">
							<span class="status compleate">채점완료</span>
						</c:when>
					</c:choose>
					<input name="hwSubmitContent" type="hidden">
					<div id=hwSubmitContent>
					</div>
					<!-- <div class="file_wrap">
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
								<i class="fas fa-times"></i>
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
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div> -->
					<div class="btn_wrap">
						<input type="submit" value="제출" class="btn btn-info">
						<!-- <input type="file" id="homework_file">
						<label for="homework_file" class="btn btn-danger">파일첨부</label> -->
					</div>	
				</div>		
			</form>
		</div>
	</div>

	<c:choose>
		<c:when test="${hwSubmitVo.hwSubmit == 'C'.charAt(0) }">
			<div class="my_score shadow" style="display:block;">
				<span class="score">${hwSubmitVo.hwSubmitScore }</span>
				<span class="bar"></span>
				<span class="total">${hwBoardVo.hwMaxScore }</span>
			</div>
		</c:when>
		<c:otherwise>
			<div class="my_score shadow" style="display:none;">
			</div>
		</c:otherwise>
	</c:choose>
</section>

<script src="${pageContext.request.contextPath}/vendor/quill/quill.min.js"></script>
<script type="text/javascript">
	var hwSubmitQill = new Quill('#hwSubmitContent', {
		placeholder: '과제 내용'
	});
	
	hwSubmitQill.setContents(${hwSubmitVo.hwSubmitContent});

	var form = document.querySelector('form');
	form.onsubmit = function() {
	  var hwSubmitContent = document.querySelector('input[name=hwSubmitContent]');
	  hwSubmitContent.value = JSON.stringify(hwSubmitQill.getContents());
	  return true;
	};
	
</script>
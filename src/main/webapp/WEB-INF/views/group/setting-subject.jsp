<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/build/css/group_main.css">

<!-- content -->
<section id="main">
	<div class="container">
		<div class="row justify-content-center">

			<!--           center            -->
			<div id="center" class="col-12 col-md-8">
				<!-- Post /////-->
				<div class="card mb-3">
					<div class="card-header d-flex justify-content-between">
						<h6>주제</h6>
					</div>
					<ul class="list-group list-group-flush">
						<c:forEach var="subject" items='${subjectList}' varStatus="status">
							<li class="list-group-item d-flex justify-content-between">
								<div class="d-flex">
									<form id="subjectProp${subject.subjectNum}" action="${pageContext.request.contextPath}/board/delete/subject" method="post">
										<input name="groupNum" type="hidden"
											value="${groupVo.groupNum}">
										<input name="subjectNum" type="hidden"
											value="${subject.subjectNum}"> <input
											name="subjectTitle" type="text"
											value="${subject.subjectTitle}">
									</form>
								</div>
								<div class="">
									<input name="" type="hidden" value="">
									<button class="btn">편집</button>
									<button class="btn delSubjectModalBtn" data-toggle="modal"
										data-target="#delSubjectModal">삭제</button>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- Post /////-->
			</div>
			<!--           center            -->

		</div>
	</div>
</section>
<!-- content -->

<!-- The Modal -->
<!--!!!!!!!!!!!!! 게시물 삭제 모달!!!!!!! -->
<div class="modal" id="delSubjectModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header">
				<h5 class="modal-title">주제를 삭제 하시겠습니까?</h5>
				<button type="button" class="close text-white" data-dismiss="modal">&times;</button>
			</div>
			<input type="hidden" value="subjectNum">
			<!-- Modal body -->
			<div class="modal-body">
				<div class="form-group">
					<p>주제에 포함된 모든 과제와 공지 또한 삭제됩니다</p>
				</div>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer justify-content-right">
				<a href="" class="text-muted" data-dismiss="modal">취소</a>
				<button id="delSubjectBtn" type="button"
					class="text-muted btn btn-out-secondary">삭제</button>
			</div>
		</div>
	</div>
</div>
<!-- The Modal -->




<!-- Card Template -->



<script>    
        const SLIDE_EXCUTION_TIME = 178;
        const NOTICE = 'N'
        const HW_BOARD = 'H'
        var subjectProp = '';
        var subjectPropObject = '';
        
        $(document).ready(function () {
        	
        	$('.delSubjectModalBtn').on('click', function (e) {
                subjectProp = e.target.parentElement.previousSibling.previousSibling.querySelector("form");
        		subjectPropObject = $("#"+subjectProp.id).serializeObject();
            });
        	
        	$('#delSubjectBtn').on('click', function (e) {
        		$("#"+subjectProp.id).submit();
            });
        });
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/quill/quill.snow.css">
<section id="view_student">
	<div class="card mb-3 mt20" id="before">
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
			<h5 class="card-title">내 과제</h5>
			<div class="homework_con">
				<form id="submitForm" action="">
					<span class="status before">할당됨</span>
					<input name="hwSubmitContent" type="hidden" id="hwSubmitContent">
					<div id="hwSubmitContent">
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
					</div>
					<div class="btn_wrap">
						<input type="button" value="제출" class="btn btn-info" id="homeworkSubmit">
						<input type="file" id="homework_file">
						<label for="homework_file" class="btn btn-danger">파일첨부</label>
					</div>
				</form>
			</div>		
		</div>
	</div>

	<script id="homeworkSubmit" type="text/x-handlebars-template">
	</script>

	<div class="my_score">
		<span class="score">50</span>
		<span class="bar"></span>
		<span class="total">100</span>
	</div>
</section>

<script src="${pageContext.request.contextPath}/vendor/quill/quill.min.js"></script>
<script type="text/javascript">
	var hwSubmitQill = new Quill('#hwSubmitContent', {
		placeholder: '과제 내용'
	});
	
	function insertHomeWork(){
		var hwContent = document.querySelector("#hwSubmitContent");
		hwContent.value = JSON.stringify(hwSubmitQill.getContents());
		
		var submitData = $("#submitForm").serializeObject();
		var dataStr = JSON.stringify(submitData);
		$.ajax({
			url : "${pageContext.request.contextPath}/insert/homework/proc",
			method : "post",
			dataType 'json',
			data : dataStr,
			processData : true,
			contentType : "application/json; charset=UTF-8"			
		}).done(function(data){
			if(data.errC === "0000"){
				$("#before").hide();
				//새로고침
				window.location.reload()
			}
		});
	}
	
	$(function(){
		$("#homeworkSubmit").on("click", insertHomeWork);
	})
	
	
	//과제 제출
	function makeHomeSubmit(data){
		var source = $("#homeworkSubmit").html();
    	var template = Handlebars.compile(source);
    	var html = template(data);
    	return html;
	}
</script>
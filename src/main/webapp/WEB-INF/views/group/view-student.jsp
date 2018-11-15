<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="view_student">
	<div class="card mb-3 mt20">
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
				<span class="status before">할당됨</span>
				<input name="about" type="hidden">
				<div id="editor-container">
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
					<input type="submit" value="제출" class="btn btn-info">
					<input type="file" id="homework_file">
					<label for="homework_file" class="btn btn-danger">파일첨부</label>
				</div>
			</div>
		</div>
	</div>

	<div class="my_score">
		<span class="score">50</span>
		<span class="bar"></span>
		<span class="total">100</span>
	</div>
</section>
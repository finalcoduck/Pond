<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<!-- <header	class="group-header bg-primary">
		<div class="inner">
			<nav class="navbar vh5">
				<h1>
					<a href="#">
						<b class="text-white">POND</b>
					</a>
				</h1>
				<div class="dropdown">
					<button class="btn" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img class="rounded-circle header-profile-img" src="https://picsum.photos/50/50" alt="">
					</button>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
						<a class="dropdown-item" href="#">마이페이지</a>
						<a class="dropdown-item" href="#">초대코드 입력</a>
						<a class="dropdown-item" href="#">로그아웃</a>
					</div>
				</div>
			</nav>
		</div>
	</header> -->
	<style type="text/css">
		*, a{color:#333;}
	</style>
	<section class="content">
		 <h1>${test }</h1>
		<div class="container mt30">
			<div class="row">
				<div class="col-12 col-md-3">
					<div class="card mypageLeft">
						<ul class="list-group list-group-flush">
							<li class="list-group-item on">
								<a href="#">내정보</a>
							</li>
							<li class="list-group-item">
								<a href="#">내가 쓴 글</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="profileWrap col-12 col-md-8">
					<h2 class="title">
						내 정보
					</h2>
					<div class="profile">
						<div class="myProfile">
							<p class="txt">내 프로필</p>
							<div class="profileArea">
								<ul>
									<li>
										<div class="profileImg">
											<img class="rounded-circle profile-img" src="https://picsum.photos/50/50" alt="">
											<span class="name">배재정</span>
										</div>
										<div class="profileBtn">
											<button type="button" data-toggle="modal" data-target="#myModal">
												수정
											</button>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="profile">
						<div class="myProfile">
							<p class="txt pt10">로그인 계정</p>
							<div class="profileArea">
								<ul>
									<li>
										<div class="profileInfo">
											<span class="txt">이메일</span>
											<span class="mail">bjj9804@naver.com</span>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<span class="txt">휴대폰 번호</span>
											<input type="text" value="01073077408">
										</div>
										<div class="profileBtn">
											<a href="#">수정</a>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<span class="txt">비밀번호</span>
											<input type="password" value="123123123">
										</div>
										<div class="profileBtn">
											<a href="#">수정</a>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="profile">
						<div class="myProfile">
							<p class="txt pt10">연결된 계정</p>
							<div class="profileArea">
								<ul>
									<li>
										<div class="profileInfo">
											<span class="txt">네이버</span>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<span class="txt">구글</span>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="profile">
						<div class="myProfile">
							<p class="txt pt10">가입된 그룹</p>
							<div class="profileArea group">
								<ul>
									<li>
										<div class="profileInfo">
											<img src="${pageContext.request.contextPath }/resources/build/image/img1.jpg" alt="" />
											<span class="txt group_name">중앙HTA 1803기</span>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<img src="${pageContext.request.contextPath }/resources/build/image/img2.jpg" alt="" />
											<span class="txt group_name">중앙HTA 1802기</span>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<img src="${pageContext.request.contextPath }/resources/build/image/img3.jpg" alt="" />
											<span class="txt group_name">중앙HTA 1801기</span>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 프로필수정 모달 -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">프로필 수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="profileImg">
						<span>
							<img src="https://picsum.photos/120/120" alt="프로필사진">
						</span>
						<input type="file" id="imgUpdate">
						<label for="imgUpdate">사진</label>
					</div>
					<input type="text" value="배재정" class="profileInput">
				</div>
				<!-- Modal footer -->
				<div class="align_c" style="padding:1rem;">
					<button type="submit" class="btn btn-secondary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	<!-- //프로필수정 모달 -->
	
	<script	src="${pageContext.request.contextPath }/resources/vendor/jquery-3.3.1/js/jquery-3.3.1.min.js"></script>
	<script	src="${pageContext.request.contextPath }/resources/vendor/bootstrap-4.1.3/js/bootstrap.min.js"></script>
	<script	src="${pageContext.request.contextPath }/resources/vendor/handlebars-v4.0.12/js/handlebars-v4.0.12.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header	class="group-header bg-primary">
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
					<a class="dropdown-item" href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
				</div>
			</div>
		</nav>
	</div>
</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style type="text/css">
		*, a{color:#333;}
	</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/group.css">
<section class="content group-wrap">
		<div class="inner">
			<h2 class="sub_title">그룹 이름</h2>
			<div class="input_box">
				<input type="text" placeholder="그룹 이름 입력">
			</div>

			<div class="coverSelect mt20">
				<div class="mainCover">
					<div class="wrapper">
						<img src="${pageContext.request.contextPath}/resources/build/image/img1.jpg" alt="" />
					</div>
				</div>
				<div class="coverList">
					<div class="head">
						<h3>커버 선택</h3>
						<div class="navi">
							
						</div>
					</div>
					<ul class="cover">
						<li>
							<input type="file" id="coverImg">
							<label for="coverImg"><span>사진 추가</span></label>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img1.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img2.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img3.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img4.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img5.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img6.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/build/image/img7.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
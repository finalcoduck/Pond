<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style type="text/css">
		*, a{color:#333;}
	</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/group.css">
<section class="content group-wrap">
		<div class="inner">
			<h2 class="sub_title">그룹 이름</h2>
			<div class="input_box">
				<input type="text" placeholder="그룹 이름 입력" id="fake-group-name">
			</div>
			
			<div class="coverSelect mt20">
				<div class="mainCover">
					<div class="wrapper">
						<img src="${pageContext.request.contextPath}/build/image/img1.jpg" alt="" id="mainImage"/>
					</div>
				</div>
				<div class="coverList">
					<div class="head">
						<h3>커버 선택</h3>
						<!-- <div class="navi">
							
						</div> -->
					</div>
					<ul class="cover">
						<li>
							<form action="${pageContext.request.contextPath }/fileupload/group-pic-upload" method="post" enctype="multipart/form-data" id="myForm">
							<input type="file" id="coverImg" name="file">
							<input type="hidden" name="groupName" id="group-name" />
							<input type="hidden" name="memEmail" value=${memDto.memVo.memEmail } />
							</form>
							<label for="coverImg"><span>사진 추가</span></label>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img1.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img2.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img3.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img4.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img5.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img6.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="${pageContext.request.contextPath}/build/image/img7.jpg" alt="" />
								<span class="mask"></span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<span>권장 사이즈 : 320x240</span><br>
			<div class="align_c mt20">
				<button type="button" class="btn" onclick="history.back();">취소</button>
				<button type="button" class="btn btn-success" id="make-group-btn">생성</button>
			</div>
		</div>
	</section>
		<script type="text/javascript">
			$(function(){
				$(".cover li a").click(function(){
					var img = $(this).children("img").attr("src");
					$(this).parent("li").addClass("on");
					$(this).parent("li").siblings().removeClass("on");
					$(".mainCover img").attr("src", img);
				});
				
				var value = $("#coverImg").val();
				$('#coverImg').on('change',function(event){
					var image = event.target.files[0];
					console.log(image);
					var imageURL = window.URL.createObjectURL(image);
					if(!validImageType(image)){
						swal({
							type : 'error',
							title : '잘못된 확장자 입니다.',
							showConfirmButton: true
						});
						return;
					}else{
						$('#mainImage').prop('src',imageURL).css({
							'width':'320px',
							'height':'240px'	
						});
						}
					});
				
				// 생성 버튼을 누를시 실행
				$('#make-group-btn').on('click',function(){
					var groupName = $('#fake-group-name').val();
					$('#group-name').val(groupName);
					var memEmail = $('input[name=memEmail]').val();
					if($('#coverImg').val() == null || $('#coverImg').val() == ''){
						var imgUrl = $('#mainImage').prop('src');
						defaultImgUpload(groupName, imgUrl, memEmail);
					}else{
						$('#myForm').submit();
					}
				});
				
				function defaultImgUpload(groupName, imgUrl, memEmail){
					$.ajax({
						url : "${pageContext.request.contextPath}/selectgroup/make-group-proc",
						type : 'post',
						data : {'groupName':groupName, 'imgUrl':imgUrl, 'memEmail':memEmail},
						success : function(data){
							window.location.href="${pageContext.request.contextPath}/selectgroup/index";
						} 
					});
				}
			});
			
			function validImageType(image){
				const result = (['image/png','image/jpeg','image/jpg'].indexOf(image.type) > -1);
				return result;
			}
		</script>
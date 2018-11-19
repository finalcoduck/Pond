<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/build/css/group.css" />    
	<style type="text/css">
		*, a{color:#333;}
	</style>
	<section class="content">
		<div class="container mt30">
			<div class="row">
				<div class="col-12 col-md-3">
					<div class="card mypageLeft">
						<ul class="list-group list-group-flush">
							<li class="list-group-item on">
								<a href="#">내정보</a>
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
											<c:choose>
												<c:when test="${memDto.memVo.memProfilePic == null}">
													<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/build/image/img1.jpg" alt="">	
												</c:when>
												<c:otherwise>
												<!-- url 이미지 주소일때와 서버에 저장한 이미지 파일인 경우 -->
													<img class="rounded-circle profile-img" src="${memDto.memVo.memProfilePic }" alt="">
													<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/upload/mem-photo/${memDto.memVo.memProfilePic }" alt="">	
												</c:otherwise>			
											</c:choose>
											<span class="name">${memDto.memVo.memName }</span>
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
												<span class="mail">${memDto.memVo.memEmail }</span>
										</div>
									</li>
									<li>
										<div class="profileInfo">
											<span class="txt">휴대폰 번호</span>
											<c:choose>
											<c:when test="${memDto.memVo.memPhone ne 0 }">
												<input type="text" value="${memDto.memVo.memPhone }"  id="phoneNum">
											</c:when>
											<c:otherwise>
												<input type="text" placeholder="휴대폰 번호를 등록해 주세요."  id="phoneNum">
											</c:otherwise>
											</c:choose>
										</div>
										<div class="profileBtn">
											<button id="updatePhoneBtn">수정</button>
										</div>
									</li>
									<li>
										<div class="profileInfo" id="pwd-txt">
											<span class="txt">비밀번호</span>
										</div>
										<div class="profileBtn">
											<c:choose>
											<c:when test="${memDto.memVo.memPwd eq 'naver' or memDto.memVo.memPwd eq 'google' }">
												<button type="button" disabled="disabled" class="btn-secondary" id="disabledBtn">
													수정 
												</button>
											</c:when>
											<c:otherwise>
												<button type="button" data-toggle="modal" data-target="#pwdModal">
													수정
												</button>
											</c:otherwise>
											</c:choose>
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
										<c:choose>
											<c:when test="${memDto.memVo.memPwd eq 'naver' }">
												<span class="txt" style="color:green;">네이버</span>
												<img src="${pageContext.request.contextPath }/resources/build/image/naver_on.png" style="border:0;">
											</c:when>
											<c:otherwise>
												<img src="${pageContext.request.contextPath }/resources/build/image/naver_off.png" style="border:0;">
											</c:otherwise>
										</c:choose>
										</div>
									</li>
									<li>
										<div class="profileInfo">
										<c:choose>
											<c:when test="${memDto.memVo.memPwd eq 'google' }">
												<img src="${pageContext.request.contextPath }/resources/build/image/google_on.png" style="border:0;">
											</c:when>
											<c:otherwise>
												<img src="${pageContext.request.contextPath }/resources/build/image/google_off.png" style="border:0;">
											</c:otherwise>
										</c:choose>
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
								<c:forEach items="${memDto.keySet }" var="groupNum">
									<li>
										<div class="profileInfo"><!-- 그룹이미지 나중에 처리 -->
											<img src="${pageContext.request.contextPath }/resources/upload/group-photo/${groupMap[groupNum].groupImage }" alt="" style="width: 50px; height: 50px;"/>
											<span class="txt group_name">${groupMap[groupNum].groupName }</span>
										</div>
									</li>
								</c:forEach>	
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
							<c:choose>
								<c:when test="${memDto.memVo.memProfilePic == null}">
									<img src="${pageContext.request.contextPath }/resources/build/image/img1.jpg" alt="" class="snImg">	
								</c:when>
								<c:otherwise>
								<!-- url 이미지 주소일때와 서버에 저장한 이미지 파일인 경우 -->
									<img src="${pageContext.request.contextPath }/resources/upload/mem-photo/${memDto.memVo.memProfilePic }" alt="" class="snImg">
									<img src="${memDto.memVo.memProfilePic }" alt="" class="snImg">	
								</c:otherwise>			
							</c:choose>
						</span>
						<form action="${pageContext.request.contextPath }/fileupload/insert-profile-pic" enctype="multipart/form-data" method="post" name="filefrm">
							<input type="file" id="imgUpdate" accept="image/png, image/jpg, image/jpeg" name="file">
							<input type="hidden" name="email" value='${memDto.memVo.memEmail }'/>
						</form>
						<label for="imgUpdate" style="background-image:url(${pageContext.request.contextPath}/resources/build/image/ico_camera_w.png);">사진</label>
					</div>
					<input type="text" value="배재정" class="profileInput" disabled="disabled" readonly="readonly">
				</div>
				<!-- Modal footer -->
				<div class="align_c" style="padding:1rem;">
					<button type="button" class="btn btn-secondary" id="change-img-btn">확인</button>
				</div>
			</div>
		</div>
	</div>
	<!-- //프로필수정 모달 -->
	
		<!-- 비밀번호 수정 모달 -->
	<div class="modal fade" id="pwdModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">비밀번호 수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<ul class="pwd_modify">
						<li>
							<span class="txt">현재 비밀번호</span>
							<input type="password" value="" id="nowPwd">
						</li>
						<li>
							<span class="txt">새 비밀번호</span>
							<input type="password" value="" id="newPwd">
						</li>
						<li>
							<span class="txt">새 비밀번호 확인</span>
							<input type="password" value="" id="newPwd2">
						</li>
					</ul>
				</div>
				<!-- Modal footer -->
				<div class="align_c" style="padding:1rem;">
					<!-- data-dismiss="modal" << 모달창 자동 닫기 해제  -->
					<button type="button" class="btn btn-secondary" id="pwdUpdateBtn">확인</button>
				</div>
			</div>
		</div>
	</div>
	<!-- //비밀번호 수정 모달 -->
	
	<script	src="${pageContext.request.contextPath }/resources/build/js/joinValidityCheck.js"></script>
	<script	src="${pageContext.request.contextPath }/resources/vendor/handlebars-v4.0.12/js/handlebars-v4.0.12.js"></script>
	<script type="text/javascript">
		$('#updatePhoneBtn').on('click',function(){
			var phoneNum = $('#phoneNum').val();
			if(confirm(phoneNum+"으로 수정하시겠습니까?")){
				$.ajax({
					url : "${pageContext.request.contextPath}/member/update-phone/proc",
					dataType : "json",
					data : {"phone":phoneNum, "email":'${memDto.memVo.memEmail}'},
					success: function(data) {
						alert('수정 완료');
					}
				});
			}else{
				return;
			}
		});
		
		//비밀번호 수정 버튼 클릭시
		$('#pwdUpdateBtn').on('click',function(){
			var nowPwd = $('#nowPwd').val();
			var newPwd = $('#newPwd').val();
			var newPwd2 = $('#newPwd2').val();
			
			$.ajax({
				url : "${pageContext.request.contextPath}/member/confirm-pwd/proc",
				dataType : "json",
				data : {'nowPwd':nowPwd, "email":'${memDto.memVo.memEmail}', "nowEncPwd":'${memDto.memVo.memPwd}'},
				success : function(data) {
						console.log(data.pwdConfirmMsg);
					if(data.pwdConfirmMsg == 'true'){
						var pwd = '${memDto.memVo.memPwd}';
						if(newPwd == newPwd2){
							var bool = regxPwd.test(newPwd);
							if(bool){
							 	$.ajax({
									url : "${pageContext.request.contextPath}/member/update-pwd/proc",
									dataType : "json",
									data : {'newPwd': newPwd, "email":'${memDto.memVo.memEmail}'},
									success: function(data) {
										$('#pwdModal').modal('hide');
										alert('비밀번호 수정완료');
									}
								}); 
							}else{
								alert('비밀번호는 8~20글자 영문,숫자,특수문자를 포함해야 합니다.');
								return;
							}
						}else{
							alert('입력한 비밀번호가 틀립니다');
							return;
						}
					}else{
						alert('현재 비밀번호가 틀립니다.');
						return;						
					}
				}
			});
			
		});
		
		$('#disabledBtn').on('click',function(){
			var msg = $('<input/>',{
				type : 'text',
				value : '네이버,구글 회원은 비밀번호 변경이 불가합니다.'
			});
			$('#pwd-txt').append(msg);
		});
		
		////////// 프로필 사진 관련 //////////
		
		//썸네일 메소드
		$('#imgUpdate').on('change',function(e){
			var image = e.target.files[0];
			if(validImageType(image)){
				$('.snImg').prop('src',window.URL.createObjectURL(image));
			}else{
				alert('png/jpg/jpeg 파일만 등록 가능합니다.');
				return;
			}
		});
		
		//파일 업로드후 멤버 프로필 사진 변경
		$('#change-img-btn').on('click',function(){
			var imgVal = $('#imgUpdate').val();
			if(imgVal == ''){
				$('#myModal').modal('hide');
			}else{
				$('form[name=filefrm]').submit();
			}
		});
		
		
		//image 확장자 유효성 검사
		function validImageType(image){
			const okImg = (['image/jpg','image/png','image/jpeg'].indexOf(image.type) > -1);
			return okImg;
		}
	</script>
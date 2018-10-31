<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
											<!-- url 이미지 주소일때와 서버에 저장한 이미지 파일인 경우 -->
											<img class="rounded-circle profile-img" src="${memDto.memVo.memProfilePic }" alt="">
											<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/resources/upload/${memDto.memVo.memProfilePic }" alt="">
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
											<c:choose>
												<c:when test="${memDto.memVo.memPwd ne 'google'}">
												<span class="mail">${memDto.memVo.memEmail }</span>
												</c:when>
												<c:otherwise>
												<span class="mail" style="color:blue;">Google 계정 연동중</span>
												</c:otherwise>
											</c:choose>
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
										<div class="profileInfo">
											<span class="txt">비밀번호</span>
										</div>
										<div class="profileBtn">
											<c:choose>
											<c:when test="${memDto.memVo.memPwd eq 'naver' && memDto.memVo.memPwd eq 'google' }">
												<button type="button" data-toggle="modal" disabled="disabled" class="btn-secondary">
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
												<span>연동중 입니다</span>
											</c:when>
											<c:otherwise>
												<span class="txt">네이버</span>
											</c:otherwise>
										</c:choose>
										</div>
									</li>
									<li>
										<div class="profileInfo">
										<c:choose>
											<c:when test="${memDto.memVo.memPwd eq 'google' }">
												<span class="txt" style="color:blue;">구글</span>
											</c:when>
											<c:otherwise>
												<span class="txt">구글</span>
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
											<img src="${pageContext.request.contextPath }/resources/build/image/img1.jpg" alt="" />
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
		
		$('#pwdUpdateBtn').on('click',function(){
			var nowPwd = $('#nowPwd').val();
			var newPwd = $('#newPwd').val();
			var newPwd2 = $('#newPwd2').val();
			
			var pwd = ${memDto.memVo.memPwd};
			if(pwd == nowPwd){
				if(newPwd == newPwd2){
					var bool = regxPwd.test(newPwd);
					if(bool){
						/* $.ajax({
							
						}); */
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
		});
	</script>
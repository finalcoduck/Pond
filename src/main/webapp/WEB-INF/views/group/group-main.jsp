<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/floating_btn.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/quill/quill.snow.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/build/css/group_main.css?ver=2">	

<!-- content -->
<section id="main">
	<div class="container mt20">
		<div class="row">
			<!--           left side            -->
			<div class="col-12 col-md-3">
				<div class="card mb-3 shadow" style="width: 100%;">
					<img class="card-img-top" src="${pageContext.request.contextPath }/upload/group-photo/${groupVo.groupImage}" alt="Card image">
					<div class="card-body">
						<h4 class="card-title">${groupVo.groupName}</h4>
						<p class="card-text">멤버 ${groupMemCount}</p>
						<a href="${pageContext.request.contextPath }/group/detail?groupNum=${groupVo.groupNum}" class="">학원 정보 상세보기</a>
					</div>
				</div>
				<div class="card mb-3 shadow">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="${pageContext.request.contextPath }/group/filelist?groupNum=${groupVo.groupNum}"><i class="far fa-folder-open"></i> 수업 자료실</a></li>
						<li class="list-group-item"><a href="${pageContext.request.contextPath }/schedule/info?groupNum=${groupVo.groupNum}"><i class="far fa-calendar-alt"></i> 일정</a></li>
						<li class="list-group-item"><a href="${pageContext.request.contextPath }/group/curriculum?groupNum=${groupVo.groupNum}"><i class="fas fa-layer-group"></i> 커리큘럼</a></li>
						<li class="list-group-item"><a href="${pageContext.request.contextPath }/group/attended?groupNum=${groupVo.groupNum}"><i class="fas fa-clipboard-check"></i> 출결</a></li>
					</ul>
				</div>
				<div class="card mb-3 shadow">
					<div class="card-header d-flex justify-content-between align-items-center">
						<div class="h6">주제</div>
	
						<div class="dropdown">
							<i class="fas fa-ellipsis-v cursor-pointer" id="gedf-drop1"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>
							<div class="dropdown-menu dropdown-menu-right"
										aria-labelledby="gedf-drop1">
								<a class="dropdown-item cursor-pointer" data-toggle="modal" data-target="#subjectModal">추가</a>
								<a href="${pageContext.request.contextPath }/group/setting-subject?groupNum=${groupVo.groupNum}" class="dropdown-item">편집</a>
							</div>
						</div>
					</div>
					<ul id="subjectList" class="list-group list-group-flush">
						<li class="cursor-pointer list-group-item">
							<a>공지</a>
						</li>
						<c:forEach var="subject" items='${subjectList}' varStatus="status">
							<li class="cursor-pointer list-group-item">
								<a>${subject.subjectTitle}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--           left side            -->


			<!--           center            -->
			<div id="center" class="col-12 col-md-8">
				<!-- Post /////-->
				<!-- Post /////-->
				<div class="actionCon text-center">
					<div class="actionType5_1">
						<div class="loding1"></div>
						<div class="loding2"></div>
						<div class="loding3"></div>
					</div>
				</div>
			</div>
			<!--           center            -->
			
		</div>
	</div>
</section>
<!-- content -->

<!-- The Modal -->
<div class="modal" id="noticeModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header bg-primary">
				<h4 class="modal-title text-white">공지</h4>
				<button type="button" class="close text-white" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
			<form id="noticeForm" action="">
				<input name="groupNum" type="hidden" value="${groupVo.groupNum}">
				<input name="boardType" type="hidden" value="N">
					<div class="form-group">
						<input name="boardContent" type="hidden">
						<div id="notice-editor-container"></div>
					</div>
					<div class="form-group col-5 col-md-4">
						<div class="input-group mb-3">
						  <div class="input-group-prepend">
						    <label class="input-group-text" for="inputGroupSelect01">주제</label>
						  </div>
						  <select class="custom-select" name="subjectTitle" id="inputGroupSelect01">
						    <option selected>공지</option>
						    <c:forEach var="subject" items='${subjectList}' varStatus="status">
							    <option value="${subject.subjectTitle}">${subject.subjectTitle}</option>
						    </c:forEach>
						  </select>
						</div>
					</div>
					</form>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer justify-content-between">
				<div id="iconBox">
					<a href=""><i class="far fa-folder-open mr-3"></i></a> <a href="">
					<i class="fas fa-link"></i></a>
				</div>
				<button id="noticeSubmitBtn" type="button" class="btn btn-out-secondary" >제출</button>
			</div>
		</div>
	</div>
</div>

<div class="modal" id="subjectModal">
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">주제 추가</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="${pageContext.request.contextPath}/board/insert/subject" method="post">
				<!-- Modal body -->
				<div class="modal-body">
						<div class="form-group">
						<input name="groupNum" type="hidden" value="${groupVo.groupNum}">
							<input name="subjectTitle" type="text">
						</div>
				</div>
	
				<!-- Modal footer -->
				<div class="modal-footer justify-content-right">
					<a href="" class="text-muted" data-dismiss="modal">취소</a>
					<button type="submit" class="text-muted btn btn-out-secondary" >추가</button>
				</div>
			</form>

		</div>
	</div>
</div>


<!-- The Modal -->
<div class="modal" id="homeworkModal">
	<div class="modal-dialog" style="max-width:700px">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header bg-primary">
				<h4 class="modal-title text-white">과제</h4>
				<button type="button" class="close text-white" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form id="homeworkForm" action="">
					<input name="groupNum" type="hidden" value="${groupVo.groupNum}">
					<input name="boardType" type="hidden" value="H">
					<div class="chk_area">
						<div class="dropdown">
							<button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">
								전체학생
							</button>
							<ul class="dropdown-menu">
								<li class="dropdown-item" data-keepOpenOnClick>
									<input type="checkbox" id="allChk">
									<label for="allChk"></label>
									<span class="txt">전체 학생</span>
								</li>
								<c:forEach items="${sList }" var="vo" varStatus="status">
		                            <li class="dropdown-item" data-keepOpenOnClick>
	                                    <input type="checkbox" id="${status.index }" name="student_list" class="mr-1" value="${vo.memEmail }">
	                                    <label for="${status.index }"></label>
                                    	<span class="txt">${vo.memName }</span>
									</li>
	                            </c:forEach>
							</ul>
						</div>
					</div>
					<div class="form-group">
						<input name="boardTitle" type="hidden" id="homeworkTitle">
						<div id="homeworkTitleContainer">
						</div>
						
						<input name="boardContent" type="hidden" id="homeworkContent">
						<div id="homeworkContentContainer">
						</div>
					</div>
					<ul class="score_area">
						<li>
							<span class="txt">점수</span>
							<input type="text" name="hwMaxScore" placeholder="100" maxlength="3">
						</li>
						<li>
							<span class="txt">마감일</span>
							<input type="date" name="hwEndDate" class="form-control">
						</li>
						<li>
							<span class="txt">주제</span>
							<select class="custom-select" name="subjectTitle"
								id="inputGroupSelect01" style="width:auto;">
								<option selected>공지</option>
								<c:forEach var="subject" items='${subjectList}'
									varStatus="status">
									<option value="${subject.subjectTitle}">${subject.subjectTitle}</option>
								</c:forEach>
							</select>
						</li>
					</ul>
				</form>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer justify-content-between">
				<button type="button" id="homeworkSubmitBtn" class="btn btn-out-secondary">제출</button>
			</div>

		</div>
	</div>
</div>
<!-- The Modal -->


<!--!!!!!!!!!!!!! 게시물 삭제 모달!!!!!!! -->
<div class="modal" id="delBoardModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content border-0">

			<!-- Modal Header -->
			<div class="modal-header">
				<h5 class="modal-title">게시물을 삭제 하시겠습니까?</h5>
				<button type="button" class="close text-white" data-dismiss="modal">&times;</button>
			</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<p>댓글도 삭제됩니다.</p> 
						<form id="delModalProp">
							<input name="boardNum" type="hidden">
							<input name="boardType" type="hidden">
							<input name="groupNum" type="hidden" value="${groupVo.groupNum}">
						</form>
					</div>
				</div>
	
				<!-- Modal footer -->
				<div class="modal-footer justify-content-right">
					<a href="" class="text-muted" data-dismiss="modal">취소</a>
					<button id="delBoardBtn" type="button" class="text-muted btn btn-out-secondary" >삭제</button>
				</div>
		</div>
	</div>
</div>

<!-- The Modal -->

<!-- floating Button-->
<div id="floatingBtnDiv" class="material-button-anim">
	<ul class="list-inline" id="options">
		<li class="option">
			<button id="homeworkBtn" class="material-button option1" type="button"
				data-container="body" data-placement="left" data-content="과제">
				<i class="fas fa-clipboard-check"></i>
			</button>
		</li>
		<li class="option">
			<button id="noticeBtn" class="material-button option2" type="button"
				data-container="body" data-placement="left" data-content="공지">
				<i class="fas fa-chalkboard"></i>
			</button>
		</li>
	</ul>
	<button id="floatingBtn" class="material-button material-button-toggle"
		type="button">
		<span class="fa fa-plus" aria-hidden="true"></span>
	</button>
</div>

<!-- Card Template -->
<script id="notice-card" type="text/x-handlebars-template">
<div class="card mb-3 shadow">
	<div class="card-header">
		<div class="d-flex justify-content-between align-items-center">
			<div class="d-flex justify-content-between align-items-center">
				<div class="mr-2">
					<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/upload/mem-photo/{{memProfilePic}}" alt="">
				</div>
				<div class="ml-2">
					<div class="h5 m-0">{{memName}}</div>
					<div class="h7 text-muted">{{boardRegDate}}</div>
				</div>
			</div>
			<div>
				<div class="dropdown">
						<i class="fas fa-ellipsis-v cursor-pointer" id="gedf-drop1"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="gedf-drop1">
						<a class="dropdown-item cursor-pointer">수정</a>
						<a class="dropdown-item cursor-pointer delModalBtn">삭제</a>
						<form id="boardProp{{boardNum}}">
							<input name="boardNum" type="hidden" value="{{boardNum}}">
							<input name="boardType" type="hidden" value="{{boardType}}">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-body">
		<h5><span class="badge badge-secondary">{{subjectTitle}}</span></h5>
		<p class="card-text">{{{boardContent}}}</p>
	</div>
	<div class="card-footer align_r">
		<a class="card-link cmt-btn cursor-pointer" id="{{boardNum}}"><i class="fa fa-comment"></i> 댓글</a>
	</div>
	<div class="comment-list" id="comment-{{boardNum}}">

	</div>
		<div class="comment-list" id="comment-{{boardNum}}"></div>
		<div class="card-footer d-flex" >
			<form action="" name="comment-form" id="cmntForm-{{boardNum}}">
      	     	<input type="hidden" name="refBoardNum" value='{{boardNum}}' />
     	      	<input type="hidden" name="cmntContent"/>
     	      	<input type="hidden" name="cmntWriter" value='{{boardWriter}}'/>
			</form>
			<div class="col-10" id="editor-test-{{boardNum}}"></div>
			<div class="col-2 align_c">
				<button class="comment-btn" id="cmnt-{{boardNum}}">작성</button>
			</div> 
		</div>
</div>
</script>

<!-- comment Template -->
<script id="comment-card" type="text/x-handlebars-template">
	<div class="card-footer d-flex">
		<div class="col-1 align_c">
			<!-- img class="rounded-circle profile-img" src="${pageContext.request.contextPath}/upload/mem-photo/{{memProfilePic}}" alt="" -->
			<img class="rounded-circle profile-img" src="https://picsum.photos/50/50" alt="">
		</div>
		<div class="col-8 comment_con">
			<span class="name">{{memName}}</span>
			{{{cmntContent}}}
		</div>
		<div class="col-3 align_r">
			<button class="btn btn-outline-danger" id="delete-{{cmntNum}}" value="delete">삭제</button>
			<input type="hidden" value="{{refBoardNum}}"/>
		</div>
	</div>
</script>
<!-- no delete commet Template -->
<script id="comment-card-no" type="text/x-handlebars-template">
	<div class="card-footer d-flex">
		<div class="col-2">
			<!-- img class="rounded-circle profile-img" src="${pageContext.request.contextPath}/upload/mem-photo/{{memProfilePic}}" alt="" -->
			<img class="rounded-circle profile-img" src="https://picsum.photos/50/50" alt="">
		</div>
		<div class="col-8">
			<span>{{memName}}</span>
			{{{cmntContent}}}
		</div>
		<input type="hidden" value="{{refBoardNum}}"/>
	</div>
</script>
 
<script type="text/javascript">
</script>

<script id="hw-card" type="text/x-handlebars-template">
	<div class="card mb-3 shadow">
		<div class="card-header">
			<div class="d-flex justify-content-between align-items-center">
				<div class="d-flex justify-content-between align-items-center">
					<div class="mr-2">
						<img class="rounded-circle profile-img" src="${pageContext.request.contextPath }/upload/mem-photo/{{memProfilePic}}" alt="">
					</div>
					<div class="ml-2">
						<div class="h5 m-0">
							{{memName}}
						</div>
						<div class="h7 text-muted">
							{{boardRegdate}}
						</div>
					</div>
				</div>

                <div>
                	<div class="dropdown">
                    	<button class="btn btn-link" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        	<i class="fas fa-ellipsis-v"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
							<a class="dropdown-item cursor-pointer">수정</a>
							<a class="dropdown-item cursor-pointer delModalBtn">삭제</a>
							<form id="boardProp{{boardNum}}">
								<input name="boardNum" type="hidden" value="{{boardNum}}">
								<input name="boardType" type="hidden" value="{{boardType}}">
							</form>
                        </div>
                    </div>
                </div>
			</div>
		</div>

		<div class="card-body homework">
			<h5 class="card-title">{{{boardTitle}}}</h5>
			<h5><span class="badge badge-secondary">{{{subjectTitle}}}</span></h5>
			<div class="homework_con">
				<div class="con_area">
					<a href="${pageContext.request.contextPath }/group/view?boardNum={{boardNum}}&groupNum=${groupVo.groupNum}">
						{{{boardContent}}}
					</a>
					<br>
					<span>
						최대부여점수 : {{hwMaxScore}}
					</span>
				</div>
				<div class="person">
					<ul>
						<li>
							<a href="#">
								<span class="num">{{proposeCount}}</span>
								<span class="txt">제출함</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="num">{{submitCount}}</span>									
								<span class="txt">할당 완료</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="card-footer align_r">
			<a class="card-link cmt-btn cursor-pointer" id="{{boardNum}}"><i class="fa fa-comment"></i> 댓글</a>
		</div>
		<div class="comment-list" id="comment-{{boardNum}}"></div>
		<div class="card-footer d-flex" >
			<form action="" name="comment-form" id="cmntForm-{{boardNum}}">
      	     	<input type="hidden" name="refBoardNum" value='{{boardNum}}' />
     	      	<input type="hidden" name="cmntContent"/>
     	      	<input type="hidden" name="cmntWriter" value='{{boardWriter}}'/>
			</form>
			<div class="col-10" id="editor-test-{{boardNum}}"></div>
			<div class="col-2 align_c">
				<button class="comment-btn" id="cmnt-{{boardNum}}">작성</button>
			</div> 
		</div>
	</div>
</script>
<!-- Card Template -->
<script src="${pageContext.request.contextPath}/vendor/quill/quill.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>

<script>    
        const SLIDE_EXCUTION_TIME = 178;

        
        var boardSrchDto= {groupNum:"${groupVo.groupNum}", srchWord:"",nxt1KeyVal:1,pagePercnt:"5",nxtPageFl:""};
        
        var NoticeQuill = new Quill('#notice-editor-container', {
            placeholder: '공지를 입력하세요',
        });
        
    	var HomeworkTitleQuill = new Quill('#homeworkTitleContainer', {
    		placeholder : '제목을 입력하세요',
    	});
    	
    	var HomeworkContentQuill = new Quill('#homeworkContentContainer', {
    		placeholder : '내용을 입력하세요(선택사항)',
    	});       
        
        var quillArr = [];
        
        $(document).ready(function () {
        	// 첫페이지 조회
	    	searchBoard();
        	
        	//공지 글 추가 버튼
        	$("#noticeSubmitBtn").on("click",insertNoticeBoard)
        	
			//과제 글 추가 버튼
			$("#homeworkSubmitBtn").on("click", insertHomeworkBoard)	        	
        	
        	//댓글 펼치기 버튼
        	$(document).on('click','.cmt-btn', function(event){
        		var boardNum = $(this).prop('id');
        		boardNum = boardNum.trim();
        		
        		var tmp = $(this).prop('value'); // 클릭 식별을 위한 코드
        		if(tmp == 'true'){
        			$('#comment-'+boardNum+'').empty();
        			$(this).prop('value','false');
        			return;
        		}
        		$(this).prop('value','true');
        		
				getCommentAJAX(boardNum);        		
        	});
        	
        	//댓글 삭제 버튼
        	$(document).on('click','button[value=delete]',function(event){
        		var refBoardNum = $(this).next().val();
        		var idValue = $(this).prop('id');
        		var sptArr = idValue.split('-');
        		var cmntNum = sptArr[1].trim();
        		
        		deleteComment(cmntNum, refBoardNum);
ㅛ        	});
        	
        	//댓글 작성 버튼
        	$(document).on('click','.comment-btn',function(event){
        		var indexBoardNum = $(this).prop('id'); // cmnt-{{boardNum}}
        		var boardNum = indexBoardNum.split('-')[1]; //해당 카드섹션 boardNum
        		var commentQuill = quillArr[boardNum];
        		
        		var content = document.querySelector("#editor-test-"+boardNum).firstChild.innerHTML;
        		
        		var cmntInput = $('#cmntForm-'+boardNum+'').children('input[name=cmntContent]').val(content);
        		var commentData = $('#cmntForm-'+boardNum+'').serializeObject();
        		var commentDataStr = JSON.stringify(commentData);
        		var editorDiv = $('#editor-test-'+boardNum+'');
        		//editor-test-{{boardNum}}
        		$.ajax({
        			url : "${pageContext.request.contextPath}/board/insert/comment/proc",
        			data : commentDataStr,
        			dataType : "json",
        			type : "post",
        			contentType : "application/json; charset=UTF-8",
        			success : function(data){
        				commentQuill.setText('');
        				$('#comment-'+boardNum+'').empty();
        				getCommentAJAX(boardNum);	
        			}
        		});
        	});
        	
	    	 //floating Button
	        $("#floatingBtn").on("click", function () {
	            setTimeout(function () {
	                if($("#floatingBtn").hasClass("open")){
	                    $("#homeworkBtn").popover('show');
	                    $("#noticeBtn").popover('show');
	                }else{
	                    $("#homeworkBtn").popover('hide');
	                    $("#noticeBtn").popover('hide');
	                }
	            }, SLIDE_EXCUTION_TIME) // floating button의 animation이 끝난 후 실행
	        });
        	
            $('.material-button-toggle').on("click", function () {
            	
                $(this).toggleClass('open');
                $('.option').toggleClass('scale-on');
            });

            $("#homeworkBtn").on("click", function () {
                $("#homeworkModal").modal('show')       
                $("#homeworkBtn").popover('show'); // 공지버튼 클릭시 popper 사라지는거 방지용
            });	            
            
            $("#noticeBtn").on("click", function () {
                $("#noticeModal").modal('show');       
                $("#noticeBtn").popover('show'); // 공지버튼 클릭시 popper 사라지는거 방지용
            });

			$('#noticeModal, #homeworkModal').on('show.bs.modal', function(e) {
				$("#floatingBtn").trigger("click");
			});

			$('#noticeModal, #homeworkModal').on('shown.bs.modal', function(e) {
				if ($("body").css("padding-right") !== "0px") {
					$("#floatingBtnDiv").addClass("add-right");
				}
			});
			$('#noticeModal, #homeworkModal').on('hidden.bs.modal', function(e) {
				$("#floatingBtnDiv").removeClass("add-right")
			});


            $(".ql-editor").addClass("max-vh50"); // 텍스트 박스 길이 제한
            
            //스크롤을 밑으로 내릴때 다음 키값에 해당하는 게시물 불러옴
            $(window).scroll(function(){
                var scrolltop = $(window).scrollTop();
                
                if( scrolltop >= $(document).height()-$(window).height()-2 &&
                		boardSrchDto.nxtPageFl === "T"){
                	$('#center').append('<div id="loading" class="actionCon"><div class="actionType5_1"><div class="loding1"></div><div class="loding2"></div><div class="loding3"></div></div></div>');	
                	searchBoard();
                }
            });
            
            //주제 클릭 이벤트
            $("#subjectList").on("click","li",searchSubject);
            
           
            //주제 삭제 모달 팝업 이벤트
            $("#setSubjectModalBtn").on("click",function(){
            	$("#setSubjectModal").modal("show");
            })
            
            
            //게시물 삭제 이벤트
            $("#delBoardBtn").on("click",sendDelBoard);

			//과제 할당학생 체크
			var $allChk = $('#allChk');
			$allChk.change(function () {
				var $this = $(this);
				var checked = $this.prop('checked'); // checked 문자열 참조(true, false)
				// console.log(checked);
				$('input[name="student_list"]').prop('checked', checked);
			});
			var boxes = $('input[name="student_list"]');
			boxes.change(function () {
				var boxLength = boxes.length;
				// 체크된 체크박스 갯수를 확인하기 위해 :checked 필터를 사용하여 체크박스만 선택한 후 length 프로퍼티를 확인
				var checkedLength = $('input[name="student_list"]:checked').length;
				var selectAll = (boxLength == checkedLength);
				$allChk.prop('checked', selectAll);
			});
        });

		$(function(){
			//모달 드롭다운 클릭시 닫지 않음
			$("ul.dropdown-menu").on("click", "[data-keepOpenOnClick]", function(e) { 
				e.stopPropagation(); 
			});
		})        
        
        //댓글 삭제
		function deleteComment(cmntNum, refBoardNum){
			$.ajax({
				url : "${pageContext.request.contextPath}/board/comment/delete/proc",
				data : {'cmntNum':cmntNum},
				success : function(data){
					if(data.msg == 'success'){
						$('#comment-'+refBoardNum+'').empty();
						getCommentAJAX(refBoardNum);	
					}
				}
			})
		}        
        
        //댓글을 받아와 해당 글에 뿌려줌
    	function getCommentAJAX(boardNum){
    		$.ajax({
    			url : "${pageContext.request.contextPath}/board/get-comment/proc",
    			dataType : "json",
    			data : {refBoardNum:boardNum},
    			success : function(data){
    				$.each(data.list, function(i, elt) {
    					console.log(data);
    					
    					var bn = data.list[i].refBoardNum;
    					$('#comment-'+bn+'').append(makeCommentCard(data.list[i],data.memEmail));
    					//makeCommentCard
    				})
    			}
    		});
    	}
        
        //게시물을 받아옴 
        function searchBoard(){
			
        	var dataStr = JSON.stringify(boardSrchDto)
        	
        	$.ajax({
		   		url : "${pageContext.request.contextPath}/board/search/proc"
				, method : "post"
		   		, dataType : 'json'
		   		, data : dataStr
		   		, processData : true
		   		, contentType : "application/json; charset=UTF-8"
			})
			.done(function(data){
				console.log(data);
				$("#loading").remove();
				
				if(data.boardList === null){
					console.log("게시물이 없습니다.")
				}else{
					
					console.log(data.boardSrchDto);
					//마지막 페이지 여부 받아오기 
					boardSrchDto.nxtPageFl = data.boardSrchDto.nxtPageFl;
					
					//키값이 1인 경우 div#center 초기화
					if(boardSrchDto.nxt1KeyVal === 1){
						$("#center").html("");	
					}

					boardSrchDto.nxt1KeyVal += 1;
					
					// 카드 추가
					data.boardList.forEach(function(item){
						item.boardRegdate = moment(item.boardRegdate).add(9,'hours').format("YYYY년 MM월 DD일 HH:mm");
						item.boardContent = item.boardContent;
						
						if(item.boardType === NOTICE){
							$("#center").append(makeNoticeCard(item));	
						}else if(item.boardType === HW_BOARD){
							$("#center").append(makeHWCard(item));	
						}
						
			            var commentQuill = new Quill('#editor-test-'+item.boardNum,{
			            	placeholder: '댓글을 입력하세요',
			            });
			            var indexBoardNum = item.boardNum;
			            quillArr[indexBoardNum]=commentQuill;
					})
					
		        	$(".delModalBtn").on("click",showDelBoardModal)
		        	
				}
		   	});
		}
        function searchSubject(){
        	
        	//boardSrchDto에 검색 주제 추가후
        	console.log(this)
        	boardSrchDto.srchWord = this.querySelector("a").innerHTML;
        	boardSrchDto.nxt1KeyVal = 1;
        	
        	//게시물 조회 실행
        	searchBoard();
        	
        	//화면 상단으로 이동
        	$('html, body').animate({scrollTop: 0 }, 'slow');
        }
        
        //
        function showDelBoardModal(e){
        	//해당 게시물의 번호와 타입을 얻어옴
        	var evt = e || window.event;
        	
        	var evtTargetId = e.target.nextSibling.nextSibling.id;
        	var boardProp = $("#"+evtTargetId).serializeObject();
        	
        	//모달에 해당 게시물의 번호와 타입을 저장 해둠
        	$("#delModalProp input[name=boardNum]").val(boardProp.boardNum);
        	$("#delModalProp input[name=boardType]").val(boardProp.boardType);
        	$("#delBoardModal").modal('show');
        }
        
        // 공지 삭제  Ajax Request
        function sendDelBoard(){
        	//모달에 저장된 삭제할 게시물 정보 불러옴
        	var delBoardProp = $("#delModalProp").serializeObject();
        	var dataStr = JSON.stringify(delBoardProp);
        	
        	$.ajax({
		   		url : "${pageContext.request.contextPath}/board/delete/proc"
				, method : "post"
		   		, dataType : 'json'
		   		, data : dataStr
		   		, processData : true
		   		, contentType : "application/json; charset=UTF-8"
			})
			.done(function(data){
				if(data.errC === "0000"){
					
					$("#delBoardModal").modal('hide');
					
					//키값 초기화후 다시 글 목록 불러오기
					boardSrchDto.nxt1KeyVal = 1;
		        	
		        	//게시물 조회 실행
		        	searchBoard();
		        	
		        	//화면 상단으로 이동
		        	$('html, body').animate({scrollTop: 0 }, 'slow');
				}
			});
        }
        
        //공지 생성 Ajax Request
        function insertNoticeBoard(){
        	
            var about = document.querySelector('input[name=boardContent]');
            
            about.value = document.querySelector("#notice-editor-container").firstChild.innerHTML;
            var noticeData = $('#noticeForm').serializeObject()
        	var dataStr = JSON.stringify(noticeData);
        	$.ajax({
		   		url : "${pageContext.request.contextPath}/board/insert/notice/proc"
				, method : "post"
		   		, dataType : 'json'
		   		, data : dataStr
		   		, processData : true
		   		, contentType : "application/json; charset=UTF-8"
			})
			.done(function(data){
				
				if(data.errC ==="0000"){
					boardSrchDto.nxt1KeyVal = 1; // 키값 초기화	
					$("#noticeModal").modal('hide');
					//searchBoard();
					//새로고침
					window.location.reload()
				}
			});
        }
        
        //과제 생성 ajax
    	function insertHomeworkBoard(){
    		var hwTitle = document.querySelector('#homeworkTitle');
    		hwTitle.value = document.querySelector("#homeworkTitleContainer").firstChild.innerHTML;;

    		var hwContent = document.querySelector('#homeworkContent');
    		hwContent.value = document.querySelector("#homeworkContentContainer").firstChild.innerHTML;;
    		
    		var homeworakData = $('#homeworkForm').serializeObject();
    		var dataStr = JSON.stringify(homeworakData);
    		//console.log(homeworakData);
    		$.ajax({
    			url : "${pageContext.request.contextPath}/board/insert/homework/proc",
    			method : "post",
    			dataType : 'json',
    			data : dataStr,
    			processData : true,
    			contentType : "application/json; charset=UTF-8"
    		}).done(function(data){
    			if(data.errC === "0000"){
    				boardSrchDto.nxt1KeyVal = 1; // 키값 초기화	
    				$("#homeworkModal").modal('hide');
    				//새로고침
    				window.location.reload()
    			}
    		});
    	}        
        
        
        //공지 카드 만들기
		function makeNoticeCard(data){
			var source = $("#notice-card").html();
	    	var template = Handlebars.compile(source);
	    	var html = template(data);
	    	return html;
		}
		//과제 카드 만들기
		function makeHWCard(data){
			var source = $("#hw-card").html();
	    	var template = Handlebars.compile(source);
	    	var html = template(data);
	    	return html;
		}
		//댓글 섹션 만들기
		function makeCommentCard(data, memEmail){
			if(data.cmntWriter == memEmail){
				var source = $("#comment-card").html();
		    	var template = Handlebars.compile(source);
		    	var html = template(data);
		    	return html;				
			}else{
				var source = $("#comment-card-no").html();
		    	var template = Handlebars.compile(source);
		    	var html = template(data);
		    	return html;				
			}
		}		
		
    </script>
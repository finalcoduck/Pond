<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/floating_btn.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/quill/quill.snow.css">

 <!-- content -->
    <section id="main">
        <div class="container">
            <div class="row">
                <!--           left side            -->
                <div class="col-12 col-md-3">
                    <div class="card mb-3" style="width:100%;">
                        <img class="card-img-top" src="https://picsum.photos/50/50" alt="Card image">
                        <div class="card-body">
                            <h4 class="card-title">중앙HTA 1803기</h4>
                            <p class="card-text">멤버 28</p>
                            <a href="#" class="">학원 정보 상세보기</a>
                        </div>
                    </div>
                    <div class="card mb-3">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <a href=""><i class="far fa-folder-open"></i> 수업 자료실</a>
                            </li>
                            <li class="list-group-item">
                                <a href=""><i class="far fa-calendar-alt"></i> 일정</a>
                                <!--선생님일 때 만 보여야함-->
                            </li>
                        </ul>
                    </div>
                    <div class="card mb-3">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <div class="h6">주제</div>
                            <a href="">
                                <i class="fas fa-plus"></i>
                            </a>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <a href="">공지</a>
                            </li>
                            <li class="list-group-item">
                                <a href="">기타</a>
                            </li>
                            <li class="list-group-item">
                                <div class="h7">등등</div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--           left side            -->
                <!--           center            -->
                <div class="col-12 col-md-8">
                    <!--- \\\\\\\Post-->
                    <div class="card mb-3">
                        <div class="card-header">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="mr-2">
                                        <img class="rounded-circle profile-img" src="https://picsum.photos/50/50" alt="">
                                    </div>
                                    <div class="ml-2">
                                        <div class="h5 m-0">강덕영</div>
                                        <div class="h7 text-muted">10월 12일</div>
                                    </div>
                                </div>
                                <div>
                                    <div class="dropdown">
                                        <button class="btn btn-link" type="button" id="gedf-drop1" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                                            <a class="dropdown-item" href="#">맨 위로 이동</a>
                                            <a class="dropdown-item" href="#">수정</a>
                                            <a class="dropdown-item" href="#">삭제</a>
                                            <a class="dropdown-item" href="#">링크복사</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">공지 카드</h5>
                            <p class="card-text">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo recusandae nulla rem
                                eos
                                ipsa praesentium esse magnam nemo dolor
                                sequi fuga quia quaerat cum, obcaecati hic, molestias minima iste voluptates.
                            </p>
                        </div>
                        <div class="card-footer align_r">
                            <a href="#" class="card-link"><i class="fa fa-comment"></i> 댓글</a>
                        </div>
                    </div>
                    <!-- Post /////-->
                    <div class="card mb-3">
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
                                <div>
                                    <div class="dropdown">
                                        <button class="btn btn-link" type="button" id="gedf-drop1" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                                            <a class="dropdown-item" href="#">맨 위로 이동</a>
                                            <a class="dropdown-item" href="#">수정</a>
                                            <a class="dropdown-item" href="#">삭제</a>
                                            <a class="dropdown-item" href="#">링크복사</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">과제 카드</h5>
                            <p class="card-text">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo recusandae nulla rem
                                eos
                                ipsa praesentium esse magnam nemo dolor
                                sequi fuga quia quaerat cum, obcaecati hic, molestias minima iste voluptates.
                            </p>
                        </div>
                        <div class="card-footer align_r">
                            <a href="#" class="card-link"><i class="fa fa-comment"></i> 댓글</a>
                        </div>
                    </div>
                    <!-- Post /////-->
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
                    <form action="">
                        <div class="form-group">
                            <input name="about" type="hidden">
                            <div id="editor-container">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="dropdown">
                                <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">
                                    주제
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Link 1</a>
                                    <a class="dropdown-item" href="#">Link 2</a>
                                    <a class="dropdown-item" href="#">Link 3</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer justify-content-between">
                    <div id="iconBox">
                        <a href=""><i class="far fa-folder-open mr-3"></i></a>
                        <a href=""><i class="fas fa-link"></i></a>
                    </div>
                    <a href="" class="text-muted" data-dismiss="modal">제출</a>
                </div>

            </div>
        </div>
    </div>
    <!-- The Modal -->

    <!-- floating Button-->
    <div id="floatingBtnDiv"class="material-button-anim">
        <ul class="list-inline" id="options">
            <li class="option">
                <button id="HWBtn" class="material-button option1" type="button" data-container="body" data-placement="left"
                    data-content="과제">
                    <i class="fas fa-clipboard-check"></i>
                </button>
            </li>
            <li class="option">
                <button id="noticeBtn" class="material-button option2" type="button" data-container="body"
                    data-placement="left" data-content="공지">
                    <i class="fas fa-chalkboard"></i>
                </button>
            </li>
        </ul>
        <button id="floatingBtn" class="material-button material-button-toggle" type="button">
            <span class="fa fa-plus" aria-hidden="true"></span>
        </button>
    </div>
    
    
    <!-- floating Button-->
	<script src="${pageContext.request.contextPath}/resources/vendor/quill/quill.min.js"></script>
	
	
	    <script>
        const slideExcutionTime = 178;

        //floating Button
        $("#floatingBtn").on("click", function () {
            setTimeout(function () {
                if($("#floatingBtn").hasClass("open")){
                    $("#HWBtn").popover('show');
                    $("#noticeBtn").popover('show');
                }else{
                    $("#HWBtn").popover('hide');
                    $("#noticeBtn").popover('hide');
                }
                
            }, slideExcutionTime) // floating button의 animation이 끝난 후 실행
        });

        $(document).ready(function () {
            
            $('.material-button-toggle').on("click", function () {
                $(this).toggleClass('open');
                $('.option').toggleClass('scale-on');
            });

            
            $("#noticeBtn").on("click", function () {
                $("#noticeModal").modal('show')       
                $("#noticeBtn").popover('show'); // 공지버튼 클릭시 popper 사라지는거 방지용
            });
            
            $('#noticeModal').on('show.bs.modal', function (e) {
                $("#floatingBtn").trigger("click");
            });

            $('#noticeModal').on('shown.bs.modal', function (e) {
                if($("body").css("padding-right")!=="0px"){
                    $("#floatingBtnDiv").addClass("add-right");
                }
                
            });
            $('#noticeModal').on('hidden.bs.modal', function (e) {
                $("#floatingBtnDiv").removeClass("add-right")
            });

            var quill = new Quill('#editor-container', {

                placeholder: '공지를 입력하세요',

            });

            $(".ql-editor").addClass("max-vh50"); // 텍스트 박스 길이 제한

            var form = document.querySelector('form');
            form.onsubmit = function () {
                // Populate hidden form on submit
                var about = document.querySelector('input[name=about]');
                about.value = JSON.stringify(quill.getContents());

                console.log("Submitted", $(form).serialize(), $(form).serializeArray());

                // No back end to actually submit to!
                alert('Open the console to see the submit data!')
                return false;
            };

        });
    </script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/build/js/joinValidityCheck.js?ver=1"></script>
 
   <section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>회원가입</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/joinOk" method="post">
                        <div class="form-group">
                            <label for="email">이메일 주소 <img src="${pageContext.request.contextPath }/build/image/required.jpg" alt="" class="required-img"/></label>
                            <input type="email" class="form-control" id="email" name="preEmail">
                        
                        	<div class="mt10">
	                            <label for="pwd">비밀번호 <img src="${pageContext.request.contextPath }/build/image/required.jpg" alt="" class="required-img"/><span></span></label>
	                            <input type="password" class="form-control" id="password" name="prePassword">
	                            <span id=""></span>
                            </div>
                            
                        	<div class="mt10">
	                            <label for="pwd-check">비밀번호 확인 <img src="${pageContext.request.contextPath }/build/image/required.jpg" alt="" class="required-img"/><span></span></label>
	                            <input type="password" class="form-control" id="password2">
	                            <span id=""></span>
                            </div>
                            
                            <div class="mt10">
	                            <label for="name">이름 <img src="${pageContext.request.contextPath }/build/image/required.jpg" alt="" class="required-img"/><span></span></label>
	                            <input type="text" class="form-control" id="name" name="preName">
	                            <span id=""></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone">휴대폰 번호(선택) <span></span></label>
                            <input type="text" class="form-control" id="phone" name="prePhone" placeholder="-없이 입력해주세요.">
                            <span id=""></span>
                        </div>
                        <button type="button" class="mt-5 btn btn-block btn-outline-primary" id="sbm-btn">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
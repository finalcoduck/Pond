<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/build/js/joinValidityCheck.js?ver=1"></script>
<section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>새 비밀번호 설정</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/member/login/changePwd" method="post" name="newPwd">
                        <div class="form-group">
                            <label for="password">비밀번호 :</label>
                            <input type="password" class="form-control" id="newPwd" name="newPwd">
                            <label for="password">비밀번호 확인 :</label>
                            <input type="password" class="form-control" id="newPwd2" name="newPwd2">                            
                        </div>
                        <button type="button" class="mt-5 btn btn-block btn-outline-primary" id="newPwdBtn">확인</button>
                    </form>
                </div>
            </div>
        </div>
</section>

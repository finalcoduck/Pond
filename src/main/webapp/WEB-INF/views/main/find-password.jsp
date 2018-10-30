<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty findMsg}">
<script type="text/javascript">
	$(function() {
		$('#isExistences').text('존재하지 않는 이메일 입니다.').css('color','red');
	});	
</script>
</c:if>
<section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>비밀번호 찾기</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/member/login/sendEmail" method="get">
                        <div class="form-group">
                            <label for="email">이메일 주소 :</label>
                            <input type="email" class="form-control" id="email" name="memEmail">
                            <span id="isExistences"></span>
                        </div>
                        <button type="submit" class="mt-5 btn btn-block btn-outline-primary">확인</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>추가 정보 입력</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/member/updatePhone" method="get">
                            <div class="form-group">
                                <label for="phone">휴대폰 번호 :</label>
                                <input type="text" class="form-control" name="memPhone">
                                <span id=""></span>
                            </div>
                        <input type="hidden" name="memEmail" value='${sessionScope.memVo.memEmail }'>
                        <button type="submit" class="mt-5 btn btn-block btn-outline-primary">확인</button>
                    </form>
                    <a href="${pageContext.request.contextPath }memDto.getMemVo().getMemEmail()/selectgroup/index">넘어가기</a>
                </div>
            </div>
        </div>
    </section>
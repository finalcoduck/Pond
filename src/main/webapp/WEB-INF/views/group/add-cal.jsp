<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>일정 등록</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath}/schedule/add-cal" method="post">
                        <div class="form-group">
                            <label for="scheduleTitle">스케줄 이름</label>
                            <input type="text" name="scheduleTitle" class="form-control"/><br>
                        
                            <label for="scheduleContent">스케줄 내용</label>
                            <input type="text" name="scheduleContent" class="form-control" /><br>
                            
                            <label for="scheduleStartDate">시작 날짜</label>
                            <input type="date" name="scheduleStartDate" class="form-control"/><br>
                            
                            <label for="scheduleEndDate">종료 날짜 </label>
                            <input type="date" name="scheduleEndDate" class="form-control"/>
                        </div>
                        <div class="align_c">
	                        <input type="hidden" value="${groupNum }" name="groupNum" />
	                        <input type="submit" class="btn btn-success" value="등록" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>


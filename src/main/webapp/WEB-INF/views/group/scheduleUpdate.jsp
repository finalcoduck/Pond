<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>일정 등록</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/schedule/updatepage" method="post">
                        <div class="form-group">
                            <label for="scheduleTitle">스케줄 이름</label>
                            <input type="text" value="${vo.scheduleTitle }" name="scheduleTitle" class="form-control"/>
                        
                            <label for="scheduleContent">스케줄 내용</label>
                            <input type="text" value="${vo.scheduleContent }" name="scheduleContent" class="form-control"/>
                            
                            <label for="scheduleStartDate">시작 날짜</label>
                            <input type="date" value="${vo.scheduleStartDate }" name="scheduleStartDate" class="form-control"/>
                            
                            <label for="scheduleEndDate">종료 날짜 </label>
                            <input type="date" value="${vo.scheduleEndDate }" name="scheduleEndDate" class="form-control"/>
                        </div>
                        	<input type="hidden" value="${vo.groupNum }" name="groupNum" />
							<input type="hidden" value="${vo.scheduleNum }" name="scheduleNum" />
                        <input type="submit" value="수정" />
                    </form>
                </div>
            </div>
        </div>
    </section>
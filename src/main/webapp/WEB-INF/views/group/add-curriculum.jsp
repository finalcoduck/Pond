<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
    <section id="">
        <div class="container">
            <div class="row mt-5 align-items-center justify-content-center">
                <div class="col-12 align_c">
                    <h2>커리큘럼 일정 등록</h2>
                </div>
                <div class="col-12 col-md-6 mt-5">
                    <form action="${pageContext.request.contextPath }/group/crc-insert" method="post">
						<input type="hidden" name="groupNum" value="${groupNum }" />	
                        <div class="form-group">
                            <label for="crcStartDate">시작 날짜:</label>
                            <input type="date" class="form-control" id="crcStartDate" name="crcStartDate">
                        </div>
                        <div class="form-group">
                            <label for="crcEndDate">종료 날짜:</label>
                            <input type="date" class="form-control" id="crcEndDate" name="crcEndDate">
                        </div>
                        <div class="form-group">
                            <label for="crcTeacher">담당 교사:</label>
                            <input type="text" class="form-control" name="crcTeacher">
                        </div>
                        <div class="form-group mt-5">
                            <label for="crcTitle">주제 :</label>
                            <input type="text" class="form-control" name="crcTitle">
                        </div>
                        <div class="form-group">
                            <label for="crcContent">내용 :</label>
                            <textarea rows="5" cols="30" class="form-control" name="crcContent"></textarea>
                        </div>
                        <button type="submit" class="mt-5 btn btn-block btn-outline-primary">커리큘럼 등록</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>

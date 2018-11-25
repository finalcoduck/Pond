<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="view">
	<div class="left">
		<p class="title">
			전체학생
		</p>
		<div class="student_list">
			<ul>
				<c:forEach items="${studentList }" var="vo">
					<li>
						<span class="profile">
							<img src="${pageContext.request.contextPath }/build/image/user.png" alt="" />
							<span class="name">
								<c:choose>
									<c:when test="${vo.hwSubmit == 'B'.charAt(0) }">
										<span style="color:red;">
											${vo.memName }
										</span>
									</c:when>
									<c:when test="${vo.hwSubmit == 'P'.charAt(0) }">
										<a href="${pageContext.request.contextPath }/group/submit?boardNum=${vo.boardNum }">
											${vo.memName }
										</a>
									</c:when>
								</c:choose>
							</span>
						</span>
						<form method="post" action="<c:url value='/board/update/homework/proc' />">							
							<input type="hidden" value="${vo.boardNum }" name="boardNum">
							<input type="hidden" value="${groupNum }" name="groupNum">
							<input type="hidden" value="${boardNum }" name="hwBoardNum">
							<span class="score">
								<span class="input_wrap">
									<input type="text" id="score" value="${vo.hwSubmitScore }" name="hwSubmitScore">
									<span> / ${hwBoardVo.hwMaxScore }</span>
									<input type="submit" value="채점" class="btn btn-primary">
								</span>
							</span>
						</form>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="right">
		<p class="homework_caption">과제제목</p>
		<div class="person">
			<ul>
				<li>
					<a href="#">
						<span class="num">${boardUserDto.proposeCount }</span>
						<span class="txt">제출함</span>
					</a>
				</li>
				<li>
					<a href="#">
						<span class="num">${boardUserDto.submitCount }</span>
						<span class="txt">할당 완료</span>
					</a>
				</li>
			</ul>
		</div>

		<div class="search">
			<select>
				<option>전체</option>
				<option>제출함</option>
				<option>할당됨</option>
				<option>채점완료</option>
			</select>
		</div>

		<ul class="student_list">
			<c:forEach items="${studentList }" var="vo">
				<li>
					<img src="${pageContext.request.contextPath }/build/image/user.png" alt="">
					<span class="name">${vo.memName }</span>
					<c:choose>
						<c:when test="${vo.hwSubmit == 'B'.charAt(0) }">
							<span class="status">할당됨</span>
						</c:when>
						<c:when test="${vo.hwSubmit == 'P'.charAt(0) }">
							<span class="status">제출함</span>
						</c:when>
						<c:when test="${vo.hwSubmit == 'C'.charAt(0) }">
							<span class="status">채점완료</span>
						</c:when>
					</c:choose>
				</li>
			</c:forEach>
		</ul>
	</div>
</section>
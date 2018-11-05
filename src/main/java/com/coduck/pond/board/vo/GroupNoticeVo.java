package com.coduck.pond.board.vo;

import java.util.Date;

//그룹 공지 게시판 파일게시판
public class GroupNoticeVo {

 // 공지 글 번호 글번호
 private Integer boardNum;

 // 그룹 번호 그룹번호
 private Integer groupNum;

 // 작성자 작성자
 private String boardWriter;

 // 글내용 글내용
 private String boardContent;

 // 등록일 
 private Date boardRegdate;

 // 주제 
 private String subjectTitle;

 // BOARD TYPE 보드 타입
 private String boardType;

 public Integer getBoardNum() {
     return boardNum;
 }

 public void setBoardNum(Integer boardNum) {
     this.boardNum = boardNum;
 }

 public Integer getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(Integer groupNum) {
     this.groupNum = groupNum;
 }

 public String getBoardWriter() {
     return boardWriter;
 }

 public void setBoardWriter(String boardWriter) {
     this.boardWriter = boardWriter;
 }

 public String getBoardContent() {
     return boardContent;
 }

 public void setBoardContent(String boardContent) {
     this.boardContent = boardContent;
 }

 public Date getBoardRegdate() {
     return boardRegdate;
 }

 public void setBoardRegdate(Date boardRegdate) {
     this.boardRegdate = boardRegdate;
 }

 public String getSubjectTitle() {
     return subjectTitle;
 }

 public void setSubjectTitle(String subjectTitle) {
     this.subjectTitle = subjectTitle;
 }

 public String getBoardType() {
     return boardType;
 }

 public void setBoardType(String boardType) {
     this.boardType = boardType;
 }

 // GroupNotice 모델 복사
 public void CopyData(GroupNoticeVo param)
 {
     this.boardNum = param.getBoardNum();
     this.groupNum = param.getGroupNum();
     this.boardWriter = param.getBoardWriter();
     this.boardContent = param.getBoardContent();
     this.boardRegdate = param.getBoardRegdate();
     this.subjectTitle = param.getSubjectTitle();
     this.boardType = param.getBoardType();
 }

@Override
public String toString() {
	return "GroupNoticeVo [boardNum=" + boardNum + ", groupNum=" + groupNum + ", boardWriter=" + boardWriter
			+ ", boardContent=" + boardContent + ", boardRegdate=" + boardRegdate + ", subjectTitle=" + subjectTitle
			+ ", boardType=" + boardType + "]";
}
 
}
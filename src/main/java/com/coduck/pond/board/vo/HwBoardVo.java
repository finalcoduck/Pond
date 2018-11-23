package com.coduck.pond.board.vo;

import java.util.Date;

//그룹 과제 게시판 파일게시판
public class HwBoardVo {

 // 과제글번호 글번호
 private Integer boardNum;

 // 그룹 번호 그룹번호
 private Integer groupNum;

 // 작성자ID 작성자
 private String boardWriter;

 // 과제 제목 글제목
 private String boardTitle;

 // 과제 내용 글내용
 private String boardContent;

 // 과제 등록일 
 private Date boardRegdate;

 // 마감일 
 private String hwEndDate;

 // 최대부여점수 
 private Integer hwMaxScore;

 // 주제 
 private String subjectTitle;

 // BOARD TYPE 보드 타입
 private char boardType;

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

 public String getBoardTitle() {
     return boardTitle;
 }

 public void setBoardTitle(String boardTitle) {
     this.boardTitle = boardTitle;
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

 public String getHwEndDate() {
     return hwEndDate;
 }

 public void setHwEndDate(String hwEndDate) {
     this.hwEndDate = hwEndDate;
 }

 public Integer getHwMaxScore() {
     return hwMaxScore;
 }

 public void setHwMaxScore(Integer hwMaxScore) {
     this.hwMaxScore = hwMaxScore;
 }

 public String getSubjectTitle() {
     return subjectTitle;
 }

 public void setSubjectTitle(String subjectTitle) {
     this.subjectTitle = subjectTitle;
 }

 public char getBoardType() {
     return boardType;
 }

 public void setBoardType(char boardType) {
     this.boardType = boardType;
 }

 // HwBoard 모델 복사
 public void CopyData(HwBoardVo param)
 {
     this.boardNum = param.getBoardNum();
     this.groupNum = param.getGroupNum();
     this.boardWriter = param.getBoardWriter();
     this.boardTitle = param.getBoardTitle();
     this.boardContent = param.getBoardContent();
     this.boardRegdate = param.getBoardRegdate();
     this.hwEndDate = param.getHwEndDate();
     this.hwMaxScore = param.getHwMaxScore();
     this.subjectTitle = param.getSubjectTitle();
     this.boardType = param.getBoardType();
 }

@Override
public String toString() {
	return "HwBoardVo [boardNum=" + boardNum + ", groupNum=" + groupNum + ", boardWriter=" + boardWriter
			+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardRegdate=" + boardRegdate
			+ ", hwEndDate=" + hwEndDate + ", hwMaxScore=" + hwMaxScore + ", subjectTitle=" + subjectTitle
			+ ", boardType=" + boardType + "]";
}
 
}
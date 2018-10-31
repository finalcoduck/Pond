package com.coduck.pond.board.vo;

import java.util.Date;

//그룹 공지 게시판 파일게시판
public class GroupNoticeVo {

 // 공지 글 번호 글번호
 private Integer ntcNum;

 // 그룹 번호 그룹번호
 private Integer groupNum;

 // 작성자 작성자
 private String ntcWriter;

 // 글내용 글내용
 private String ntcContent;

 // 등록일 
 private Date ntcRegdate;

 // 주제 
 private String subject;

 // BOARD TYPE 보드 타입
 private String boardType;

 public Integer getNtcNum() {
     return ntcNum;
 }

 public void setNtcNum(Integer ntcNum) {
     this.ntcNum = ntcNum;
 }

 public Integer getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(Integer groupNum) {
     this.groupNum = groupNum;
 }

 public String getNtcWriter() {
     return ntcWriter;
 }

 public void setNtcWriter(String ntcWriter) {
     this.ntcWriter = ntcWriter;
 }

 public String getNtcContent() {
     return ntcContent;
 }

 public void setNtcContent(String ntcContent) {
     this.ntcContent = ntcContent;
 }

 public Date getNtcRegdate() {
     return ntcRegdate;
 }

 public void setNtcRegdate(Date ntcRegdate) {
     this.ntcRegdate = ntcRegdate;
 }

 public String getSubject() {
     return subject;
 }

 public void setSubject(String subject) {
     this.subject = subject;
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
     this.ntcNum = param.getNtcNum();
     this.groupNum = param.getGroupNum();
     this.ntcWriter = param.getNtcWriter();
     this.ntcContent = param.getNtcContent();
     this.ntcRegdate = param.getNtcRegdate();
     this.subject = param.getSubject();
     this.boardType = param.getBoardType();
 }

@Override
public String toString() {
	return "GroupNotice [ntcNum=" + ntcNum + ", groupNum=" + groupNum + ", ntcWriter=" + ntcWriter + ", ntcContent="
			+ ntcContent + ", subject=" + subject + ", boardType=" + boardType + "]";
}
 
 
}
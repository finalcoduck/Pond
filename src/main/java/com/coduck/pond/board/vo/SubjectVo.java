package com.coduck.pond.board.vo;

//주제 
public class SubjectVo {

 // 주제 번호 
 private Integer subjectNum;

 // 그룹 번호 
 private Integer groupNum;

 // 주제 
 private String subjectTitle;

 public Integer getSubjectNum() {
     return subjectNum;
 }

 public void setSubjectNum(Integer subjectNum) {
     this.subjectNum = subjectNum;
 }

 public Integer getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(Integer groupNum) {
     this.groupNum = groupNum;
 }

 public String getSubjectTitle() {
     return subjectTitle;
 }

 public void setSubjectTitle(String subjectTitle) {
     this.subjectTitle = subjectTitle;
 }

 // Subject 모델 복사
 public void CopyData(SubjectVo param)
 {
     this.subjectNum = param.getSubjectNum();
     this.groupNum = param.getGroupNum();
     this.subjectTitle = param.getSubjectTitle();
 }

	@Override
	public String toString() {
		return "SubjectVo [subjectNum=" + subjectNum + ", groupNum=" + groupNum + ", subjectTitle=" + subjectTitle + "]";
	}
 
 
}
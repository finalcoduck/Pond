package com.coduck.pond.curriculum.vo;

import java.sql.Date;

public class CurriculumVo {
	private int crcNum;
	private String crcTeacher;
	private int groupNum;
	private Date crcStartDate;
	private Date crcEndDate;
	private String crcTitle;
	private String crcContent;
	
	public CurriculumVo() {
		// TODO Auto-generated constructor stub
	}

	public CurriculumVo(int crcNum, String crcTeacher, int groupNum, Date crcStartDate, Date crcEndDate, String crcTitle,
			String crcContent) {
		super();
		this.crcNum = crcNum;
		this.crcTeacher = crcTeacher;
		this.groupNum = groupNum;
		this.crcStartDate = crcStartDate;
		this.crcEndDate = crcEndDate;
		this.crcTitle = crcTitle;
		this.crcContent = crcContent;
	}

	public int getCrcNum() {
		return crcNum;
	}

	public void setCrcNum(int crcNum) {
		this.crcNum = crcNum;
	}

	public String getcrcTeacher() {
		return crcTeacher;
	}

	public void setcrcTeacher(String crcTeacher) {
		this.crcTeacher = crcTeacher;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public Date getCrcStartDate() {
		return crcStartDate;
	}

	public void setCrcStartDate(Date crcStartDate) {
		this.crcStartDate = crcStartDate;
	}

	public Date getCrcEndDate() {
		return crcEndDate;
	}

	public void setCrcEndDate(Date crcEndDate) {
		this.crcEndDate = crcEndDate;
	}

	public String getCrcTitle() {
		return crcTitle;
	}

	public void setCrcTitle(String crcTitle) {
		this.crcTitle = crcTitle;
	}

	public String getCrcContent() {
		return crcContent;
	}

	public void setCrcContent(String crcContent) {
		this.crcContent = crcContent;
	}

	@Override
	public String toString() {
		return "CurriculumVo [crcNum=" + crcNum + ", crcTeacher=" + crcTeacher + ", groupNum=" + groupNum
				+ ", crcStartDate=" + crcStartDate + ", crcEndDate=" + crcEndDate + ", crcTitle=" + crcTitle
				+ ", crcContent=" + crcContent + "]";
	}
	
	
}

package com.coduck.pond.curriculum.vo;

import java.util.Date;

public class CurriculumVo {
	private int crcNum;
	private String crcWriter;
	private int groupNum;
	private Date crcStartDate;
	private Date crcEndDate;
	private String crcTitle;
	private String crcContent;
	
	public CurriculumVo() {
		// TODO Auto-generated constructor stub
	}

	public CurriculumVo(int crcNum, String crcWriter, int groupNum, Date crcStartDate, Date crcEndDate, String crcTitle,
			String crcContent) {
		super();
		this.crcNum = crcNum;
		this.crcWriter = crcWriter;
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

	public String getCrcWriter() {
		return crcWriter;
	}

	public void setCrcWriter(String crcWriter) {
		this.crcWriter = crcWriter;
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
		return "CurriculumVo [crcNum=" + crcNum + ", crcWriter=" + crcWriter + ", groupNum=" + groupNum
				+ ", crcStartDate=" + crcStartDate + ", crcEndDate=" + crcEndDate + ", crcTitle=" + crcTitle
				+ ", crcContent=" + crcContent + "]";
	}
	
	
}

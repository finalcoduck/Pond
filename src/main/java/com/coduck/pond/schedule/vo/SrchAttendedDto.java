package com.coduck.pond.schedule.vo;

import java.sql.Date;

public class SrchAttendedDto {
	
	private int attendedNum;
	private String memEmail;
	private int groupNum;
	private Date srchDate; 
	
	public SrchAttendedDto() {
		
	}
	
	public int getAttendedNum() {
		return attendedNum;
	}
	public void setAttendedNum(int attendedNum) {
		this.attendedNum = attendedNum;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public Date getSrchDate() {
		return srchDate;
	}

	public void setSrchDate(Date srchDate) {
		this.srchDate = srchDate;
	}

	@Override
	public String toString() {
		return "SrchAttendedDto [attendedNum=" + attendedNum + ", memEmail=" + memEmail + ", groupNum=" + groupNum
				+ ", srchDate=" + srchDate + "]";
	}
}

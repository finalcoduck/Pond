package com.coduck.pond.schedule.vo;

import java.sql.Date;

public class AttendedVo {
	private int attendedNum;
	private String memEmail;
	private int groupNum;
	private Date attendedIn;
	private Date attendedOut;
	private String attendedType;
	
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
	public Date getAttendedIn() {
		return attendedIn;
	}
	public void setAttendedIn(Date attendedIn) {
		this.attendedIn = attendedIn;
	}
	public Date getAttendedOut() {
		return attendedOut;
	}
	public void setAttendedOut(Date attendedOut) {
		this.attendedOut = attendedOut;
	}
	public String getAttendedType() {
		return attendedType;
	}
	public void setAttendedType(String attendedType) {
		this.attendedType = attendedType;
	}
	
	@Override
	public String toString() {
		return "AppendedVo [attendedNum=" + attendedNum + ", memEmail=" + memEmail + ", groupNum=" + groupNum
				+ ", attendedIn=" + attendedIn + ", attendedOut=" + attendedOut + ", attendedType=" + attendedType
				+ "]";
	}
	
}

package com.coduck.pond.schedule.vo;

import java.sql.Date;

public class ScheduleVo {
	private int scheduleNum;
	private int groupNum;
	private Date scheduleStartDate;
	private Date scheduleEndDate;
	private String scheduleTitle;
	private String scheduleContent;
	
	public ScheduleVo() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleVo(int scheduleNum, int groupNum, Date scheduleStartDate, Date scheduleEndDate, String scheduleTitle,
			String scheduleContent) {
		super();
		this.scheduleNum = scheduleNum;
		this.groupNum = groupNum;
		this.scheduleStartDate = scheduleStartDate;
		this.scheduleEndDate = scheduleEndDate;
		this.scheduleTitle = scheduleTitle;
		this.scheduleContent = scheduleContent;
	}

	public int getScheduleNum() {
		return scheduleNum;
	}

	public void setScheduleNum(int scheduleNum) {
		this.scheduleNum = scheduleNum;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public Date getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(Date scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public Date getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(Date scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	@Override
	public String toString() {
		return "ScheduleVo [scheduleNum=" + scheduleNum + ", groupNum=" + groupNum + ", scheduleStartDate="
				+ scheduleStartDate + ", scheduleEndDate=" + scheduleEndDate + ", scheduleTitle=" + scheduleTitle
				+ ", scheduleContent=" + scheduleContent + "]";
	}
	
	
}

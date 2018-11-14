package com.coduck.pond.member.vo;

import java.sql.Date;

public class KickHistory {
	private int kickout_history_num;
	private int groupNum;
	private String memEmail;
	private Date kickDate;
	
	public KickHistory() {
		// TODO Auto-generated constructor stub
	}

	public KickHistory(int kickout_history_num, int groupNum, String memEmail, Date kickDate) {
		super();
		this.kickout_history_num = kickout_history_num;
		this.groupNum = groupNum;
		this.memEmail = memEmail;
		this.kickDate = kickDate;
	}

	public int getKickout_history_num() {
		return kickout_history_num;
	}

	public void setKickout_history_num(int kickout_history_num) {
		this.kickout_history_num = kickout_history_num;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public Date getKickDate() {
		return kickDate;
	}

	public void setKickDate(Date kickDate) {
		this.kickDate = kickDate;
	}

	@Override
	public String toString() {
		return "KickHistory [kickout_history_num=" + kickout_history_num + ", groupNum=" + groupNum + ", memEmail="
				+ memEmail + ", kickDate=" + kickDate + "]";
	}
	
	
}

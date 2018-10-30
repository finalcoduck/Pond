package com.coduck.pond.group.vo;

public class GroupMemVo {
	private int groupMemNum;
	private int groupNum;
	private String memEmail;
	private Character status;
	
	public GroupMemVo() {
		// TODO Auto-generated constructor stub
	}

	public GroupMemVo(int groupMemNum, int groupNum, String memEmail, Character status) {
		super();
		this.groupMemNum = groupMemNum;
		this.groupNum = groupNum;
		this.memEmail = memEmail;
		this.status = status;
	}

	public int getGroupMemNum() {
		return groupMemNum;
	}

	public void setGroupMemNum(int groupMemNum) {
		this.groupMemNum = groupMemNum;
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GroupMemVo [groupMemNum=" + groupMemNum + ", groupNum=" + groupNum + ", memEmail=" + memEmail
				+ ", status=" + status + "]";
	}
	
	
	
}

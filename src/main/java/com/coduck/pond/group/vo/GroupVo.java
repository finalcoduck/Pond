package com.coduck.pond.group.vo;

import java.sql.Date;

public class GroupVo {
	private int groupNum;
	private String groupName;
	private Date openDate;
	private int maxMemNum;
	private String memEmail;
	private String inviteCode;
	private char inviteCodeStatus;
	private String groupImage;
	private String groupDescription;
	
	public GroupVo() {
		// TODO Auto-generated constructor stub
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getMaxMemNum() {
		return maxMemNum;
	}

	public void setMaxMemNum(int maxMemNum) {
		this.maxMemNum = maxMemNum;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public char getInviteCodeStatus() {
		return inviteCodeStatus;
	}

	public void setInviteCodeStatus(char inviteCodeStatus) {
		this.inviteCodeStatus = inviteCodeStatus;
	}

	public String getGroupImage() {
		return groupImage;
	}

	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public GroupVo(int groupNum, String groupName, Date openDate, int maxMemNum, String memEmail, String inviteCode,
			char inviteCodeStatus, String groupImage, String groupDescription) {
		super();
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.openDate = openDate;
		this.maxMemNum = maxMemNum;
		this.memEmail = memEmail;
		this.inviteCode = inviteCode;
		this.inviteCodeStatus = inviteCodeStatus;
		this.groupImage = groupImage;
		this.groupDescription = groupDescription;
	}

	@Override
	public String toString() {
		return "GroupVo [groupNum=" + groupNum + ", groupName=" + groupName + ", openDate=" + openDate + ", maxMemNum="
				+ maxMemNum + ", memEmail=" + memEmail + ", inviteCode=" + inviteCode + ", inviteCodeStatus="
				+ inviteCodeStatus + ", groupImage=" + groupImage + ", groupDescription=" + groupDescription + "]";
	}
}

package com.coduck.pond.group.vo;

import java.sql.Date;

public class GroupMemNumDto {
	private int groupNum;
	private String groupName;
	private Date openDate;
	private int maxMemNum;
	private String memEmail;
	private String inviteCodeS;
	private String inviteCodeM;
	private char inviteCodeStatus;
	private String groupImage;
	private String groupDescription;
	private int groupMemNum;
	private char status;
	
	public GroupMemNumDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupMemNumDto(int groupNum, String groupName, Date openDate, int maxMemNum, String memEmail,
			String inviteCodeS, String inviteCodeM, char inviteCodeStatus, String groupImage, String groupDescription,
			int groupMemNum, char status) {
		super();
		this.groupNum = groupNum;
		this.groupName = groupName;
		this.openDate = openDate;
		this.maxMemNum = maxMemNum;
		this.memEmail = memEmail;
		this.inviteCodeS = inviteCodeS;
		this.inviteCodeM = inviteCodeM;
		this.inviteCodeStatus = inviteCodeStatus;
		this.groupImage = groupImage;
		this.groupDescription = groupDescription;
		this.groupMemNum = groupMemNum;
		this.status = status;
	}

	@Override
	public String toString() {
		return "GroupMemNumDto [groupNum=" + groupNum + ", groupName=" + groupName + ", openDate=" + openDate
				+ ", maxMemNum=" + maxMemNum + ", memEmail=" + memEmail + ", inviteCodeS=" + inviteCodeS
				+ ", inviteCodeM=" + inviteCodeM + ", inviteCodeStatus=" + inviteCodeStatus + ", groupImage="
				+ groupImage + ", groupDescription=" + groupDescription + ", groupMemNum=" + groupMemNum + ", status="
				+ status + "]";
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

	public String getInviteCodeS() {
		return inviteCodeS;
	}

	public void setInviteCodeS(String inviteCodeS) {
		this.inviteCodeS = inviteCodeS;
	}

	public String getInviteCodeM() {
		return inviteCodeM;
	}

	public void setInviteCodeM(String inviteCodeM) {
		this.inviteCodeM = inviteCodeM;
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

	public int getGroupMemNum() {
		return groupMemNum;
	}

	public void setGroupMemNum(int groupMemNum) {
		this.groupMemNum = groupMemNum;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	
}

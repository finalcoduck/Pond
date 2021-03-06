package com.coduck.pond.group.vo;

import java.sql.Date;

public class GroupVo {
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
	private String attendedQRCode;
    // 전화번호 
    private String groupPhoneNum;

    // 학원주소 
    private String groupAddr;

    // 경도 
    private Double latitude;

    // 위도 
    private Double longitude;
	
	public GroupVo() {
		// TODO Auto-generated constructor stub
	}

	public GroupVo(int groupNum, String groupName, Date openDate, int maxMemNum, String memEmail, String inviteCodeS,
			String inviteCodeM, char inviteCodeStatus, String groupImage, String groupDescription) {
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
	}

	

	@Override
	public String toString() {
		return "GroupVo [groupNum=" + groupNum + ", groupName=" + groupName + ", openDate=" + openDate + ", maxMemNum="
				+ maxMemNum + ", memEmail=" + memEmail + ", inviteCodeS=" + inviteCodeS + ", inviteCodeM=" + inviteCodeM
				+ ", inviteCodeStatus=" + inviteCodeStatus + ", groupImage=" + groupImage + ", groupDescription="
				+ groupDescription + ", attendedQRCode=" + attendedQRCode + ", groupPhoneNum=" + groupPhoneNum
				+ ", groupAddr=" + groupAddr + ", latitude=" + latitude + ", longitude=" + longitude + "]";
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

	public String getAttendedQRCode() {
		return attendedQRCode;
	}

	public void setAttendedQRCode(String attendedQRCode) {
		this.attendedQRCode = attendedQRCode;
	}
    public String getGroupPhoneNum() {
        return groupPhoneNum;
    }

    public void setGroupPhoneNum(String groupPhoneNum) {
        this.groupPhoneNum = groupPhoneNum;
    }

    public String getGroupAddr() {
        return groupAddr;
    }

    public void setGroupAddr(String groupAddr) {
        this.groupAddr = groupAddr;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
	
}

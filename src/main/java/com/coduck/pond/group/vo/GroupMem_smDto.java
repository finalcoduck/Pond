package com.coduck.pond.group.vo;

public class GroupMem_smDto {
	private String memProfilePic;
	private String memPhoen;
	private String memName;
	private int groupMemNum;
	private int groupNum;
	private String memEmail;
	private Character status;
	
	public GroupMem_smDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupMem_smDto(String memProfilePic, String memPhoen, String memName, int groupMemNum, int groupNum,
			String memEmail, Character status) {
		super();
		this.memProfilePic = memProfilePic;
		this.memPhoen = memPhoen;
		this.memName = memName;
		this.groupMemNum = groupMemNum;
		this.groupNum = groupNum;
		this.memEmail = memEmail;
		this.status = status;
	}

	public String getMemProfilePic() {
		return memProfilePic;
	}

	public void setMemProfilePic(String memProfilePic) {
		this.memProfilePic = memProfilePic;
	}

	public String getMemPhoen() {
		return memPhoen;
	}

	public void setMemPhoen(String memPhoen) {
		this.memPhoen = memPhoen;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
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
		return "GroupMem_smDto [memProfilePic=" + memProfilePic + ", memPhoen=" + memPhoen + ", memName=" + memName
				+ ", groupMemNum=" + groupMemNum + ", groupNum=" + groupNum + ", memEmail=" + memEmail + ", status="
				+ status + "]";
	}
	
}

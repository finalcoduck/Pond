package com.coduck.pond.member.vo;

import java.sql.Date;

public class MemVo {
	private String memEmail;
	private String memPwd;
	private String memName;
	private String memPhone;
	private char memStatus;
	private String memId;
	private Date memRegdate;
	private String memProfilePic;
	
	public MemVo() {
		// TODO Auto-generated constructor stub
	}

	public MemVo(String memEmail, String memPwd, String memName, String memPhone, char memStatus, String memId,
			Date memRegdate, String memProfilePic) {
		super();
		this.memEmail = memEmail;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memStatus = memStatus;
		this.memId = memId;
		this.memRegdate = memRegdate;
		this.memProfilePic = memProfilePic;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public char getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(char memStatus) {
		this.memStatus = memStatus;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Date getMemRegdate() {
		return memRegdate;
	}

	public void setMemRegdate(Date memRegdate) {
		this.memRegdate = memRegdate;
	}

	public String getMemProfilePic() {
		return memProfilePic;
	}

	public void setMemProfilePic(String memProfilePic) {
		this.memProfilePic = memProfilePic;
	}

	@Override
	public String toString() {
		return "MemVo [memEmail=" + memEmail + ", memPwd=" + memPwd + ", memName=" + memName + ", memPhone=" + memPhone
				+ ", memStatus=" + memStatus + ", memId=" + memId + ", memRegdate=" + memRegdate + ", memProfilePic="
				+ memProfilePic + "]";
	}
	
}

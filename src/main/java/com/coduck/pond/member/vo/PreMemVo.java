package com.coduck.pond.member.vo;

public class PreMemVo {
	private String preEmail;
	private String prePassword;
	private String preName;
	private String prePhone;
	
	public PreMemVo() {
		// TODO Auto-generated constructor stub
	}

	public PreMemVo(String preEmail, String prePassword, String preName, String prePhone) {
		super();
		this.preEmail = preEmail;
		this.prePassword = prePassword;
		this.preName = preName;
		this.prePhone = prePhone;
	}

	public String getPreEmail() {
		return preEmail;
	}

	public void setPreEmail(String preEmail) {
		this.preEmail = preEmail;
	}

	public String getPrePassword() {
		return prePassword;
	}

	public void setPrePassword(String prePassword) {
		this.prePassword = prePassword;
	}

	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public String getPrePhone() {
		return prePhone;
	}

	public void setPrePhone(String prePhone) {
		this.prePhone = prePhone;
	}

	@Override
	public String toString() {
		return "PreMemVo [preEmail=" + preEmail + ", prePassword=" + prePassword + ", preName=" + preName
				+ ", prePhone=" + prePhone + "]";
	}
	
	

}

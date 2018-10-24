package com.coduck.pond.member.vo;

public class MemAuthVo {
	private String authKey;
	private String email;
	
	public MemAuthVo() {
		// TODO Auto-generated constructor stub
	}

	public MemAuthVo(String authKey, String email) {
		super();
		this.authKey = authKey;
		this.email = email;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

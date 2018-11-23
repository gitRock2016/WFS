package com.jp.wonfes.domain.auth;

public enum WfsSss {
	ID("s_loginId"),NAME("s_loginName"),ISLOGIN("login"),OK("OK"),TARGET("target");
	
	private String code;
	

	public String getCode() {
		return code;
	}


	private WfsSss(String code) {
		this.code = code;
	}
	
}

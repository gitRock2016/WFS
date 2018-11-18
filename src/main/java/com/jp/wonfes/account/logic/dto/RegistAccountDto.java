package com.jp.wonfes.account.logic.dto;

import com.jp.wonfes.account.controller.form.AccountRegistForm;

public class RegistAccountDto {
	private String userid;

	private String username;

	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static RegistAccountDto form2Dto(AccountRegistForm form) {
		RegistAccountDto dto = new RegistAccountDto();
		dto.setUserid(form.getUserid());
		dto.setPassword(form.getPassword());
		dto.setUsername(form.getUsername());
		return dto;
	}
	
}

package com.jp.wonfes.account.controller.form;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountRegistForm {

	@NotEmpty
	@Length(max = 10)
	private String userid;

	@Length(max = 50)
	private String username;

	@NotEmpty
	@Length(min=5, max = 32)
	private String password;
	
	@NotEmpty
	@Length(min=5, max = 32)
	private String passwordSecond;

	//	private String passwoSecSecound
	// passwordSecondはクライアント側のみで利用するため定義しない
	
	// TODO 半角数値、半角英数値のチェックを実装すること

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPasswordSecond() {
		return passwordSecond;
	}

	public void setPasswordSecond(String passwordSecond) {
		this.passwordSecond = passwordSecond;
	}

	@AssertTrue(message="{wfs.msg.e.accnt2}")
	public boolean isSamePassword() {
		return this.password.equals(this.passwordSecond);
	}

}

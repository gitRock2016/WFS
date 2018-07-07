package com.jp.wonfes.auth;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountRegistForm01 {

	/*
	 * TODO BeanValidationを活用したチェック チェックはされるが、エラーメッセージがなぜか表示されない。
	 * チェック自体はされるため、とりあえず動作させる
	 */
//	@NotBlank(message = "{errsmg001}")
	@NotEmpty(message = "{errsmg001}")
	@Length(max = 10, message = "useridは最大10文字までしか入力できません。")
	private String userid;

	@Length(max = 50, message = "usernamaeは最大50文字までしか入力できません。")
	private String username;

	@NotBlank
	@Length(max = 32, message = "passwordは最大32文字までしか入力できません。")
	private String password;

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

}

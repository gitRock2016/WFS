package com.jp.wonfes.common;

import java.util.Arrays;

/**
 * TODO アカウント情報テーブルから自動生成でクラスをつくるまでの暫定利用クラス
 * @author rock
 *
 */
public class Account {
	
	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * TODO 常に有効で暫定作成
	 * @return
	 */
	public boolean isEnabled() {
		return true;
	}
	
	// TODO 暫定でadimin権限ユーザーを記載
	private static final String[] admins = { "iwatakhr", "tomcat" };
	public boolean isAdmin() {
		if (Arrays.asList(admins).contains(this.userName)) {
			return true;
		} else {
			return false;
		}
	}
}

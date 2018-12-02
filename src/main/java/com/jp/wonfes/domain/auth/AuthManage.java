package com.jp.wonfes.domain.auth;

import org.springframework.util.DigestUtils;

public class AuthManage {
	public static String getPasswordEnryptionAccount(byte[] password) {
		return DigestUtils.md5DigestAsHex(password);
	}
	public static String getPasswordEnryptionAccount(String password) {
		return getPasswordEnryptionAccount(password.getBytes());
	}

}

package com.jp.wonfes.common;

public enum ImgIconOperation {
	NOCHANGE("0"), DELETED("1");

	private String value;

	ImgIconOperation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

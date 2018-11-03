package com.jp.wonfes.common;

public enum BusinessClassificationEnum {
	Individual(1,"個人"), Corporation(2,"法人");
	
	private Integer code;
	private String name;

	BusinessClassificationEnum(Integer code, String name){
		this.code=code;
		this.name=name;
	}
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	public static BusinessClassificationEnum valueOf(Integer code) {
		for(BusinessClassificationEnum e : values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("no such enum object for the code: " + code);
	}
}

package com.jp.wonfes.domain.code;

public enum BusinessClassificationCd {
	INDIVI("1","個人"),
	CORPO("2","法人");

	private String code;
	private String name;

	BusinessClassificationCd(String code, String name){
		this.code=code;
		this.name=name;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	public static BusinessClassificationCd getByCode(String code) {
		for(BusinessClassificationCd e : values()) {
			if(e.getCode().equals(code)) {
				return e;
			}
		}
		throw new IllegalArgumentException("no such enum object for the code: " + code);
	}

	
}

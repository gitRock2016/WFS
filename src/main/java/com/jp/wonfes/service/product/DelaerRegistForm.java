package com.jp.wonfes.service.product;


public class DelaerRegistForm {
	private String dealerCode;
	private String dealerName;
	private String takuban;
	private Integer[] filed;
	private String sex;
	private String birthplace;
	
	
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	public Integer[] getFiled() {
		return filed;
	}
	public void setFiled(Integer[] filed) {
		this.filed = filed;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	

	
}

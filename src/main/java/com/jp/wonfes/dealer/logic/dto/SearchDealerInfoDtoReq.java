package com.jp.wonfes.dealer.logic.dto;

public class SearchDealerInfoDtoReq {
	private String dealerName;
	private String takuban;
	private String businessClassification;
	private String productFiled;
	
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
	public String getBusinessClassification() {
		return businessClassification;
	}
	public void setBusinessClassification(String businessClassification) {
		this.businessClassification = businessClassification;
	}
	public String getProductFiled() {
		return productFiled;
	}
	public void setProductFiled(String productFiled) {
		this.productFiled = productFiled;
	}
	
}

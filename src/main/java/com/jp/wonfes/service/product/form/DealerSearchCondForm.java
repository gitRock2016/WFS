package com.jp.wonfes.service.product.form;

public class DealerSearchCondForm {
	private String dealerName;
	private String businessClassification;
	private String takuban;
	private String productFiled;
	
	// 非推奨 TODO 後で削除すること
	private String[] product_fields;

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String[] getProduct_fields() {
		return product_fields;
	}

	public void setProduct_fields(String[] product_fields) {
		this.product_fields = product_fields;
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
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}

}

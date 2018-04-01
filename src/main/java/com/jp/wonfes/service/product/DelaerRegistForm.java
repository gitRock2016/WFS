	package com.jp.wonfes.service.product;

import java.util.List;

public class DelaerRegistForm {
	private String dealerName;
	private String takuban;
	private List<DealerRegistSearchResultProductForm> productList;
	
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
	public List<DealerRegistSearchResultProductForm> getProductList() {
		return productList;
	}
	public void setProductList(List<DealerRegistSearchResultProductForm> productList) {
		this.productList = productList;
	}

}

	package com.jp.wonfes.dealer.controller.form;

import java.util.List;

public class DealerInfoForm {
	private Integer id;
	private String dealerIconUrl;
	private String dealerName;
	private String takuban;
	private String businessClassification;
	private String hpLink;
	private String twLink;
	private List<String> productsCategories;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDealerIconUrl() {
		return dealerIconUrl;
	}
	public void setDealerIconUrl(String dealerIconUrl) {
		this.dealerIconUrl = dealerIconUrl;
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
	public String getBusinessClassification() {
		return businessClassification;
	}
	public void setBusinessClassification(String businessClassification) {
		this.businessClassification = businessClassification;
	}
	public String getHpLink() {
		return hpLink;
	}
	public void setHpLink(String hpLink) {
		this.hpLink = hpLink;
	}
	public String getTwLink() {
		return twLink;
	}
	public void setTwLink(String twLink) {
		this.twLink = twLink;
	}
	public List<String> getProductsCategories() {
		return productsCategories;
	}
	public void setProductsCategories(List<String> productsCategories) {
		this.productsCategories = productsCategories;
	}
	
	
}

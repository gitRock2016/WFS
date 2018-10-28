	package com.jp.wonfes.dealer.controller.form;

import java.util.List;

import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoReq;
import com.jp.wonfes.dealer.logic.dto.SearchDealerInfoDtoResp;

public class DealerInfoForm {
	private Integer id;
	private String dealerIconUrl;
	private String dealerName;
	private String takuban;
	private String businessClassification;
	// TODO 画面上で利用していなければ、削除すること
	private List<String> productsCategories;
	private String productsCategoriesLabel;
	private String hpLink;
	private String twLink;
	private List<DealersDetailProducts> productList;
	
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
	public String getProductsCategoriesLabel() {
		return productsCategoriesLabel;
	}
	public void setProductsCategoriesLabel(String productsCategoriesLabel) {
		this.productsCategoriesLabel = productsCategoriesLabel;
	}
	public List<DealersDetailProducts> getProductList() {
		return productList;
	}
	public void setProductList(List<DealersDetailProducts> productList) {
		this.productList = productList;
	}
	
	// TODO dtoをJSP二マッピングさせるので不要
//	public static DealerInfoForm dto2form(SearchDealerInfoDtoResp dto) {
//		DealerInfoForm f = new DealerInfoForm();
//		
//		f.setId(dto.getId());
//		f.setDealerIconUrl(dto.getDealerIconUrl());
//		f.setDealerName(dto.getDealerName());
//		f.setTakuban(dto.getTakuban());
//		f.setBusinessClassification(dto.getBusinessClassification());
//		f.setHpLink(dto.getHpLink());
//		f.setTwLink(dto.getTwLink());
//		f.setProductsCategoriesLabel(productsCategoriesLabel);
//		return f;
//	}
	
	
}

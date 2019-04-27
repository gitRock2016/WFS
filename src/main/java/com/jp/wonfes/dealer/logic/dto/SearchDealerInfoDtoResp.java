package com.jp.wonfes.dealer.logic.dto;

import java.util.List;

import com.jp.wonfes.cmmn.dao.qo.Dealers;

public class SearchDealerInfoDtoResp {
	private Integer id;
	private String dealerIconUrl;
	private String dealerName;
	private String takuban;
	private String businessClassification;
	private String businessClassificationLabel;
//	private List<String> productFileds;
	private String productFileds;
	private String hpLink;
	private String twLink;
	private List<SearchDealerInfoProductDtoResp> productList;
	
	
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
	public String getBusinessClassificationLabel() {
		return businessClassificationLabel;
	}
	public void setBusinessClassificationLabel(String businessClassificationLabel) {
		this.businessClassificationLabel = businessClassificationLabel;
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
	
	public String getProductFileds() {
		return productFileds;
	}
	public void setProductFileds(String productFileds) {
		this.productFileds = productFileds;
	}
	
	public List<SearchDealerInfoProductDtoResp> getProductList() {
		return productList;
	}
	public void setProductList(List<SearchDealerInfoProductDtoResp> productList) {
		this.productList = productList;
	}
	public static SearchDealerInfoDtoResp qo2Dto(Dealers qo) {
		SearchDealerInfoDtoResp dto = new SearchDealerInfoDtoResp();
		dto.setId(qo.getDealerId());
		dto.setDealerName(qo.getDealerName());
		dto.setBusinessClassification(qo.getBussinesType());
		dto.setTakuban(qo.getTakuban());
		// productFiledsは別途登録が必要
		dto.setProductFileds("");
		dto.setHpLink(qo.getHpLink());
		dto.setTwLink(qo.getTwLink());
		
		return dto;
	}
	
}

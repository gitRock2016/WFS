package com.jp.wonfes.account.logic.dto;

import com.jp.wonfes.account.dao.qo.SelectUserFavProductsQoResp;

public class SearchAccountDtoResp {
	private String productName;
	private String categoryName;
	private Integer price;
	private String takuban;
	private String dealerName;
	private Integer dealerId;
	private Integer productId;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public static SearchAccountDtoResp qo2Dto(SelectUserFavProductsQoResp qo) {
		SearchAccountDtoResp dto = new SearchAccountDtoResp();
		dto.setCategoryName(qo.getCategoryName());
		dto.setDealerName(qo.getDealerName());
		dto.setPrice(qo.getPrice());
		dto.setProductName(qo.getProductName());
		dto.setTakuban(qo.getTakuban());
		dto.setDealerId(qo.getDealerId());
		dto.setProductId(qo.getProductId());
		
		return dto;
	}
}

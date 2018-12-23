package com.jp.wonfes.account.logic.dto;

public class SearchUsersInfoDtoResp {
	private Integer usrId;
	private String insDate;
	private String isExistFavProduct;
	public Integer getUsrId() {
		return usrId;
	}
	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	public String getIsExistFavProduct() {
		return isExistFavProduct;
	}
	public void setIsExistFavProduct(String isExistFavProduct) {
		this.isExistFavProduct = isExistFavProduct;
	}
	
}

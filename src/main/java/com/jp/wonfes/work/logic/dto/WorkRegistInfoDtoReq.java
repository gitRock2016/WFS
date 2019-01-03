package com.jp.wonfes.work.logic.dto;

import java.util.List;

import com.jp.wonfes.domain.work.WorkImg;

public class WorkRegistInfoDtoReq {
	private Integer dealerId;
	private Integer productId;
	private String productName;
	private Integer price;
	private String introduce;
	private Integer seasonId;
	private List<WorkImg> workImgs;
	
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}
	public List<WorkImg> getWorkImgs() {
		return workImgs;
	}
	public void setWorkImgs(List<WorkImg> workImgs) {
		this.workImgs = workImgs;
	}
	
	
}

package com.jp.wonfes.work.logic.dto;

import org.springframework.web.multipart.MultipartFile;

public class WorkRegistInfoDtoReq {
	private Integer dealerId;
	private Integer productId;
	private String productName;
	private Integer categoryId;
	private Integer price;
	private String introduce;
	private Integer seasonId;
	private MultipartFile workImg1;
	private MultipartFile workImg2;
	private MultipartFile workImg3;
	private MultipartFile workImg4;
	private MultipartFile workImg5;
	
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
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	public MultipartFile getWorkImg1() {
		return workImg1;
	}
	public void setWorkImg1(MultipartFile workImg1) {
		this.workImg1 = workImg1;
	}
	public MultipartFile getWorkImg2() {
		return workImg2;
	}
	public void setWorkImg2(MultipartFile workImg2) {
		this.workImg2 = workImg2;
	}
	public MultipartFile getWorkImg3() {
		return workImg3;
	}
	public void setWorkImg3(MultipartFile workImg3) {
		this.workImg3 = workImg3;
	}
	public MultipartFile getWorkImg4() {
		return workImg4;
	}
	public void setWorkImg4(MultipartFile workImg4) {
		this.workImg4 = workImg4;
	}
	public MultipartFile getWorkImg5() {
		return workImg5;
	}
	public void setWorkImg5(MultipartFile workImg5) {
		this.workImg5 = workImg5;
	}

	

	
}

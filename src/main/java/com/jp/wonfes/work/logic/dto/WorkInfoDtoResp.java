package com.jp.wonfes.work.logic.dto;

import java.util.List;

public class WorkInfoDtoResp {
	private Integer dealerId;
	private Integer productId;
	private String workName;
	private Integer price;
	private Integer productFiled;
	private String productFileds;
	private String comment;
	private Integer eventDate;
	private String eventAboutDate;
	private List<String> productImgUrls;

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
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProductFiled() {
		return productFiled;
	}
	public void setProductFiled(Integer productFiled) {
		this.productFiled = productFiled;
	}
	public String getProductFileds() {
		return productFileds;
	}
	public void setProductFileds(String productFileds) {
		this.productFileds = productFileds;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getEventDate() {
		return eventDate;
	}
	public void setEventDate(Integer eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventAboutDate() {
		return eventAboutDate;
	}
	public void setEventAboutDate(String eventAboutDate) {
		this.eventAboutDate = eventAboutDate;
	}
	public List<String> getProductImgUrls() {
		return productImgUrls;
	}
	public void setProductImgUrls(List<String> productImgUrls) {
		this.productImgUrls = productImgUrls;
	}
	
}

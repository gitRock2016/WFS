package com.jp.wonfes.work.controller.form;

import org.springframework.web.multipart.MultipartFile;

public class WorkRegistForm {
	private Integer dealerId;
	private String workName;
	private Integer price;
	private String productFileds;
	private String comment;
	private String eventDate;
	private MultipartFile workImg1;

	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
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
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public MultipartFile getWorkImg1() {
		return workImg1;
	}
	public void setWorkImg1(MultipartFile workImg1) {
		this.workImg1 = workImg1;
	}
	
}

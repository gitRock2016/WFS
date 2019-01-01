package com.jp.wonfes.work.controller.form;

public class WorkSearchCondForm {
	private String workName;
	private Integer priceFrom;
	private Integer priceTo;
	private String eventDate;
	private String productFiled;
	
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Integer getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(Integer priceFrom) {
		this.priceFrom = priceFrom;
	}
	public Integer getPriceTo() {
		return priceTo;
	}
	public void setPriceTo(Integer priceTo) {
		this.priceTo = priceTo;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getProductFiled() {
		return productFiled;
	}
	public void setProductFiled(String productFiled) {
		this.productFiled = productFiled;
	}
	
	
}

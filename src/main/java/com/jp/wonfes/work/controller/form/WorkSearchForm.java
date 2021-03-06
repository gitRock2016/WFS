package com.jp.wonfes.work.controller.form;

public class WorkSearchForm {
	private String workName;
	private Integer priceFrom;
	private Integer priceTo;
	private String eventDateLabel;
	private Integer eventDate;
	private Integer productFiled;
	private String productFiledLabel;
	
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
	public String getEventDateLabel() {
		return eventDateLabel;
	}
	public void setEventDateLabel(String eventDateLabel) {
		this.eventDateLabel = eventDateLabel;
	}
	public Integer getEventDate() {
		return eventDate;
	}
	public void setEventDate(Integer eventDate) {
		this.eventDate = eventDate;
	}
	public Integer getProductFiled() {
		return productFiled;
	}
	public void setProductFiled(Integer productFiled) {
		this.productFiled = productFiled;
	}
	public String getProductFiledLabel() {
		return productFiledLabel;
	}
	public void setProductFiledLabel(String productFiledLabel) {
		this.productFiledLabel = productFiledLabel;
	}
}

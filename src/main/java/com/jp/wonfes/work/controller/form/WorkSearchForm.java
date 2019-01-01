package com.jp.wonfes.work.controller.form;

import java.util.List;

public class WorkSearchForm {
	private String workName;
	private Integer priceFrom;
	private Integer priceTo;
	private String eventDateLabel;
	private Integer eventDate;
	private Integer productFiled;
	private Integer workListCount;
	private List<WorkSearchResultRow> workList;
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
	public Integer getWorkListCount() {
		return workListCount;
	}
	public void setWorkListCount(Integer workListCount) {
		this.workListCount = workListCount;
	}
	public List<WorkSearchResultRow> getWorkList() {
		return workList;
	}
	public void setWorkList(List<WorkSearchResultRow> workList) {
		this.workList = workList;
	}
	
	
}

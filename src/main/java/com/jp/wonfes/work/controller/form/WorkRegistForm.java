package com.jp.wonfes.work.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class WorkRegistForm {
	
	@NotNull
	private Integer dealerId;
	@NotEmpty
	@Length(max=20)
	private String workName;
	@NotNull
	@Min(0)
	private Integer price;
	@NotNull
	private Integer productFiled;
	private String productFiledLabel;
	@NotNull
	@Length(min=0,max=200)
	private String comment;
	@NotNull
	private Integer eventDate;
	private MultipartFile workImg1;
	private MultipartFile workImg2;
	private MultipartFile workImg3;
	private MultipartFile workImg4;
	private MultipartFile workImg5;
	private String workImg1Url;
	private String workImg2Url;
	private String workImg3Url;
	private String workImg4Url;
	private String workImg5Url;
	
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
	public String getWorkImg1Url() {
		return workImg1Url;
	}
	public void setWorkImg1Url(String workImg1Url) {
		this.workImg1Url = workImg1Url;
	}
	public String getWorkImg2Url() {
		return workImg2Url;
	}
	public void setWorkImg2Url(String workImg2Url) {
		this.workImg2Url = workImg2Url;
	}
	public String getWorkImg3Url() {
		return workImg3Url;
	}
	public void setWorkImg3Url(String workImg3Url) {
		this.workImg3Url = workImg3Url;
	}
	public String getWorkImg4Url() {
		return workImg4Url;
	}
	public void setWorkImg4Url(String workImg4Url) {
		this.workImg4Url = workImg4Url;
	}
	public String getWorkImg5Url() {
		return workImg5Url;
	}
	public void setWorkImg5Url(String workImg5Url) {
		this.workImg5Url = workImg5Url;
	}
	
	
	
}

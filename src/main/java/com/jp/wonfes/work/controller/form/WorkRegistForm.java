package com.jp.wonfes.work.controller.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class WorkRegistForm {
	
	@NotNull
	private Integer dealerId;
	@NotEmpty
	// 名前が数字だけを入力した場合、数値の最大値としてチェックされてしまう（文字列長としてチェックしない）ため、Lengthを利用する
//	@Max(20)
	@Length(max=20)
	private String workName;
	@NotNull
	@Min(0)
	private Integer price;
	@NotNull
	private Integer productFiled;
	@NotNull
//	@Max(200)
	@Length(min=0,max=200)
	private String comment;
	@NotNull
	private Integer eventDate;
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
	
	
}

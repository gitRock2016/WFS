	package com.jp.wonfes.service.product.form;

import org.springframework.web.multipart.MultipartFile;

public class DelaerRegistForm {
	private Integer id;
	private String dealerName;
	private String takuban;
	private MultipartFile dealerIconImg;
	private String hpLink;
	private String twLink;
	  
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	public String getHpLink() {
		return hpLink;
	}
	public void setHpLink(String hpLink) {
		this.hpLink = hpLink;
	}
	public String getTwLink() {
		return twLink;
	}
	public void setTwLink(String twLink) {
		this.twLink = twLink;
	}
	public MultipartFile getDealerIconImg() {
		return dealerIconImg;
	}
	public void setDealerIconImg(MultipartFile dealerIconImg) {
		this.dealerIconImg = dealerIconImg;
	}



}

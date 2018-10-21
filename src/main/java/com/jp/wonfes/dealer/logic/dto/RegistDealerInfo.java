package com.jp.wonfes.dealer.logic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import com.jp.wonfes.dealer.controller.form.DealerRegistForm;

public class RegistDealerInfo {
	private Integer id;
	private String dealerName;
	private String dealerIconCd;
	private String dealerIconUrl;
	private String takuban;
	private String businessClassification;
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
	public String getDealerIconCd() {
		return dealerIconCd;
	}
	public void setDealerIconCd(String dealerIconCd) {
		this.dealerIconCd = dealerIconCd;
	}
	public String getDealerIconUrl() {
		return dealerIconUrl;
	}
	public void setDealerIconUrl(String dealerIconUrl) {
		this.dealerIconUrl = dealerIconUrl;
	}
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	public String getBusinessClassification() {
		return businessClassification;
	}
	public void setBusinessClassification(String businessClassification) {
		this.businessClassification = businessClassification;
	}
	public MultipartFile getDealerIconImg() {
		return dealerIconImg;
	}
	public void setDealerIconImg(MultipartFile dealerIconImg) {
		this.dealerIconImg = dealerIconImg;
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
	  
	// beanmaper
	public static RegistDealerInfo form2Dto(DealerRegistForm f) {
		RegistDealerInfo r = new RegistDealerInfo();
		r.setId(f.getId());
		r.setDealerName(f.getDealerName());
		r.setDealerIconCd(f.getDealerIconCd());
		r.setDealerIconUrl(f.getDealerIconUrl());
		r.setTakuban(f.getTakuban());
		r.setBusinessClassification(f.getBusinessClassification());
		r.setDealerIconImg(f.getDealerIconImg());
		r.setHpLink(f.getHpLink());
		r.setTwLink(f.getTwLink());
		return r;
	}
	
}

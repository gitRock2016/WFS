package com.jp.wonfes.dealer.controller.form;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Strings;

public class DealerRegistForm {
	private Integer id;
	@NotBlank
	private String dealerName;
	private String dealerIconCd;
	private String dealerIconUrl;
	private String takuban;
	private String businessClassification;
	private MultipartFile dealerIconImg;
	@URL
	private String hpLink;
	@URL
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
	public String getBusinessClassification() {
		return businessClassification;
	}
	public void setBusinessClassification(String businessClassification) {
		this.businessClassification = businessClassification;
	}
	
	@AssertTrue(message="{wfs.msg.e.dealer99}")
	public boolean isNumericTakuban() {
		if(Strings.isNullOrEmpty(this.takuban)) {return true;} // nullの場合はチェックしない
		return this.takuban.matches("[0-9]{6}");
	}


}

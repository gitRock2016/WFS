	package com.jp.wonfes.service.product.form;

import org.springframework.web.multipart.MultipartFile;

public class DelaerRegistForm {
	private Integer id;
	private String dealerName;
	private String dealerIconCd;
	private String dealerIconUrl;
	private String takuban;
	private MultipartFile dealerIconImg;
	private String hpLink;
	private String twLink;
	private String dealerIconImgDelFlg;
	  
	
	
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
	public String getDealerIconImgDelFlg() {
		return dealerIconImgDelFlg;
	}
	public void setDealerIconImgDelFlg(String dealerIconImgDelFlg) {
		this.dealerIconImgDelFlg = dealerIconImgDelFlg;
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
	


}

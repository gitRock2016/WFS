package com.jp.wonfes.service.dao.product;

public class DealerInfoQo {
	private Integer dealerId;
	private String name;
	private String takuban;
	private String dealerIconCd ;
	private String hpLink  ;
	private String twLink;
	
	
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDealerIconCd() {
		return dealerIconCd;
	}
	
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	public void setDealerIconCd(String dealerIconCd) {
		this.dealerIconCd = dealerIconCd;
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
	
	
}

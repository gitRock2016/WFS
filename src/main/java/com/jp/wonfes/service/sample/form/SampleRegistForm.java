package com.jp.wonfes.service.sample.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class SampleRegistForm{
	
	private Integer dealerId;
	private String dealerName;
	private MultipartFile dealerIcon;

	public SampleRegistForm() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getDealerId() {
		return dealerId;
	}


	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}


	public String getDealerName() {
		return dealerName;
	}


	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	public MultipartFile getDealerIcon() {
		return dealerIcon;
	}


	public void setDealerIcon(MultipartFile dealerIcon) {
		this.dealerIcon = dealerIcon;
	}


}

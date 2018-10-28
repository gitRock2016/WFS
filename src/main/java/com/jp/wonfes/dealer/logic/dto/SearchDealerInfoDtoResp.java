package com.jp.wonfes.dealer.logic.dto;

import java.util.ArrayList;
import java.util.List;

import com.jp.wonfes.cmmn.dao.qo.Dealers;

public class SearchDealerInfoDtoResp {
	private Integer id;
	private String dealerName;
	private String takuban;
	private String businessClassification;
	private List<String> productFiled;
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
	public String getBusinessClassification() {
		return businessClassification;
	}
	public void setBusinessClassification(String businessClassification) {
		this.businessClassification = businessClassification;
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
	public List<String> getProductFiled() {
		return productFiled;
	}
	public void setProductFiled(List<String> productFiled) {
		this.productFiled = productFiled;
	}
	public static SearchDealerInfoDtoResp qo2Dto(Dealers qo) {
		SearchDealerInfoDtoResp dto = new SearchDealerInfoDtoResp();
		dto.setId(qo.getDealerId());
		dto.setDealerName(qo.getDealerName());
		dto.setBusinessClassification(qo.getBussinesType());
		dto.setTakuban(qo.getTakuban());
		dto.setProductFiled(new ArrayList<String>() {
			{add("艦これ");add("東方");}
		});
		dto.setHpLink(qo.getHpLink());
		dto.setTwLink(qo.getTwLink());
		
		return dto;
	}
	
}

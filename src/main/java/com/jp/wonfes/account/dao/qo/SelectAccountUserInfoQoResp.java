package com.jp.wonfes.account.dao.qo;

import java.time.LocalDateTime;
import java.util.Date;

public class SelectAccountUserInfoQoResp {

	private String usrId;
	private String passwd;
	private String userName;
	private LocalDateTime insDate;
	private LocalDateTime updDate;
//	private Date insDate;
//	private Date updDate;
	private String role;
	private Integer dealerId;
	private Integer productId;
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getInsDate() {
		return insDate;
	}
	public void setInsDate(LocalDateTime insDate) {
		this.insDate = insDate;
	}
	public LocalDateTime getUpdDate() {
		return updDate;
	}
	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}
	
//	public Date getInsDate() {
//		return insDate;
//	}
//	public void setInsDate(Date insDate) {
//		this.insDate = insDate;
//	}
//	public Date getUpdDate() {
//		return updDate;
//	}
//	public void setUpdDate(Date updDate) {
//		this.updDate = updDate;
//	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	
}

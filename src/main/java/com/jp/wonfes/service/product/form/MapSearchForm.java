package com.jp.wonfes.service.product.form;

/**
 * 地図画面を表示するのに必要となりそうなパラメータを格納する
 * @author rock
 *
 */
public class MapSearchForm {

	private String dealerId;
	private String takuban;

	public String getTakuban() {
		return takuban;
	}

	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	

	
	

}

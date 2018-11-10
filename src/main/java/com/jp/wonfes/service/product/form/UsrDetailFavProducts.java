package com.jp.wonfes.service.product.form;

public class UsrDetailFavProducts {

// JSONの想定
// '{"fav":[{"name":"あかちょむ","takuban":"08-22-04"},{"name":"Piyopiyo堂","takuban":"07-30-07"}]}';
	 
	private String name;
	private String takuban;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTakuban() {
		return takuban;
	}
	public void setTakuban(String takuban) {
		this.takuban = takuban;
	}
	
	
}

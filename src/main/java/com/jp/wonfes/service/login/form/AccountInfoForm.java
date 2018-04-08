package com.jp.wonfes.service.login.form;

import java.util.ArrayList;
import java.util.List;

public class AccountInfoForm {
	private List<AccountInfoFavProuctForm> favList;

	public List<AccountInfoFavProuctForm> getFavList() {
		return favList;
	}
	
	public AccountInfoForm() {
		super();
		this.favList= new ArrayList<AccountInfoFavProuctForm>();
	}


	public void setFavList(List<AccountInfoFavProuctForm> favList) {
		this.favList = favList;
	}
	
}

package com.jp.wonfes.service.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountInfoController {
	@RequestMapping(value = "/g03/init", method = RequestMethod.GET)
	public String init(Model model) {
		
		model.addAttribute("data", this.getMock().getFavList());
		model.addAttribute("message", "アカウント情報画面");
		return "accountinfo";
	}
	
	private AccountInfoForm getMock() {
		AccountInfoForm accountInfoForm = new AccountInfoForm();
		AccountInfoFavProuctForm f1 = new AccountInfoFavProuctForm();
		f1.setProductName("みほりん　水着");
		f1.setPrice(1234);
		f1.setDealerName("かがみはら");
		accountInfoForm.getFavList().add(f1);
		
		AccountInfoFavProuctForm f2 = new AccountInfoFavProuctForm();
		f2.setProductName("ましゅ　水着");
		f2.setPrice(199999);
		f2.setDealerName("しまりん");
		accountInfoForm.getFavList().add(f2);
		
		return accountInfoForm;
	}
}

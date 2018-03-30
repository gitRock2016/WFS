package com.jp.wonfes.service.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountInfoController {
	@RequestMapping(value = "/g03/init", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("message", "アカウント情報画面");
		return "accountinfo";
	}
}

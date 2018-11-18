package com.jp.wonfes.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.account.controller.form.AccountRegistForm;
import com.jp.wonfes.account.logic.AccountRegistLogic;
import com.jp.wonfes.account.logic.dto.RegistAccountDto;
import com.jp.wonfes.common.WfsLogicException;

@Controller
public class AccountRegistController {
	
	@Autowired
	private AccountRegistLogic accountRegistLogic;
	
	@RequestMapping(value = "/accnt/accnt_03/init", method = RequestMethod.GET)
	public String init(@ModelAttribute AccountRegistForm form, Model model) {
		return "accountregist";
	}

	@RequestMapping(value = "/accnt/accnt_03/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute @Valid AccountRegistForm form, BindingResult results, Model model) {

		if (results.hasErrors()) {
			return "accountregist";
		}

		RegistAccountDto registAccountDto = RegistAccountDto.form2Dto(form);
		try {
			accountRegistLogic.registAccountInfo(registAccountDto);
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "accountregist";
		}
		return "redirect:/accnt/accnt_01";
	}
	
}

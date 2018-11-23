package com.jp.wonfes.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jp.wonfes.account.controller.form.AccountRegistForm;
import com.jp.wonfes.account.logic.AccountRegistLogic;
import com.jp.wonfes.account.logic.dto.RegistAccountDto;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;

@Controller
public class AccountRegistController {
	@Autowired
	private WfsMessage msg;
	@Autowired
	private AccountRegistLogic accountRegistLogic;
	
	@RequestMapping(value = "/accnt/accnt_03/init", method = RequestMethod.GET)
	public String init(@ModelAttribute AccountRegistForm form, Model model) {
		return "accountregist";
	}

	@RequestMapping(value = "/accnt/accnt_03/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute @Valid AccountRegistForm form, BindingResult results, Model model,RedirectAttributes redirectAttributes) {

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
		redirectAttributes.addFlashAttribute("success_message",
				msg.getMessage("wfs.msg.e.cmmn1", new String[] { "アカウント情報の登録" }));
		form.setPassword(null); // パスワードはリダイレクト先で表示させない
		redirectAttributes.addFlashAttribute("loginForm", form);
		
		return "redirect:/accnt/accnt_01";
	}
	
}

package com.jp.wonfes.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Strings;
import com.jp.wonfes.service.dao.common.Usr;
import com.jp.wonfes.service.dao.common.mapper.UsrMapper;

@Controller
public class AccountRegistController {
	
	@Autowired
	private UsrMapper usrmapper;
	
	public AccountRegistController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/g02/init", method=RequestMethod.GET)
	public String init() {
		return "accountregist";
	}

	@RequestMapping(value="/g02/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute("acform") @Valid AccountRegistForm01 form, BindingResult results,
			Model model) {
		
		final String userid=form.getUserid();
		final String username=form.getUsername();
		final String password=form.getPassword();

		// TODO 暫定チェック、BeadnValidation、JSなど活用してきちんとしてものにすること
		// チェック
		String err = "";
		boolean isEr = false;
//		if (Strings.isNullOrEmpty(userid) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(username)) {
//			isEr = true;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    　
//			err = err + "エラー：入力されていません";
//			model.addAttribute("message", err);
//			return "accountregist";
//		}
		// TODO BeanValidationを利用した処理
		if(results.hasErrors()) {
//			results.reject("aaa", "errormessage!");
			isEr = true;
			err = err + "エラー：入力値が不正です、TODO　BeanValidationによるエラーメッセージが出ないので、代わりにこのメッセージを手動で出力している";
//			model.addAttribute("message", err);
			model.addAttribute("acform2", form);
//			model.addAttribute(form);
//			model.addAttribute("message", "TODO 一旦つかわない");
//			errors.reject("", "errordayo!");
//			errors.rejectValue("userid", "aaa", "errordayo");
			return "accountregist";
		}
		
		if (usrmapper.selectByPrimaryKey(userid) != null) {
			isEr=true;
			err = err + "エラー：すでに登録されています";
			model.addAttribute("message", err);
			return "accountregist";
		}
		
		// アカウント登録処理
		Usr usr = new Usr();
		usr.setUid(userid);
		usr.setPasswd(DigestUtils.md5DigestAsHex(password.getBytes()));
		usr.setUnam(username);
		usrmapper.insert(usr);
		
		return "accountregistfin";
	}

}

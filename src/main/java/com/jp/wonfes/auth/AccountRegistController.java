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
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;

@Controller
public class AccountRegistController {

	@Autowired
	private UsrMapper usrmapper;

	public AccountRegistController() {
	}

	@RequestMapping(value = "/g02/init", method = RequestMethod.GET)
	public String init(@ModelAttribute AccountRegistForm01 form) {
		return "accountregist";
	}

	@RequestMapping(value = "/g02/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute @Valid AccountRegistForm01 form, BindingResult results, Model model) {

		final String userid = form.getUserid();
		final String username = form.getUsername();
		final String password = form.getPassword();

		if (results.hasErrors()) {
			return "accountregist";
		}

		if (usrmapper.selectByPrimaryKey(userid) != null) {
			results.reject("wfs.msg.e.accnt1");
			return "accountregist";
		}

		// アカウント登録処理
		Usr usr = new Usr();
		usr.setUsrId(userid);
		usr.setPasswd(DigestUtils.md5DigestAsHex(password.getBytes()));
		usr.setUserName(username);
		usrmapper.insert(usr);

		return "accountregistfin";
	}

}

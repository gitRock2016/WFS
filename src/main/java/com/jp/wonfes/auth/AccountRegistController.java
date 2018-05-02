package com.jp.wonfes.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
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
	public String regist(@ModelAttribute AccountRegistForm01 form, Model model) {
		
		final String userid=form.getUserid();
		final String username=form.getUsername();
		final String password=form.getPassword();

		// TODO 暫定チェック、JSなど活用してきちんととくること
		// チェック
		String err = "";
		boolean isEr = false;
		if (Strings.isNullOrEmpty(userid) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(username)) {
			isEr = true;
			err = err + "エラー：入力されていません";
			model.addAttribute("message", err);
			return "accountregist";
		}
		
		// TODO md5暗号化処理に変更
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

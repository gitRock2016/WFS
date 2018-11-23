package com.jp.wonfes.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.jp.wonfes.account.controller.form.LoginForm;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;

@Controller
public class AccountManageController {
	
	@Autowired
	private UsrMapper usrmapper;
	
	@RequestMapping(value = "/accnt/accnt_01", method = RequestMethod.GET)
	public String init(Model model) {
		return "login";
	}

	@RequestMapping(value = "/accnt/accnt_01", method = RequestMethod.POST)
	public String auth(HttpSession session, @ModelAttribute LoginForm form, Model model) {

		String userid=form.getUserid();
		String password=form.getPassword();

		if(this.isAuth(userid, password)) {
			// 認証OKの場合
			session.setAttribute("login", "OK");

			Usr u = usrmapper.selectByPrimaryKey(userid);
			session.setAttribute("s_loginId", u.getUsrId());
			session.setAttribute("s_loginName", u.getUserName());
			
			String target = (String) session.getAttribute("target");
			if(target!=null) {
				// ログイン画面以外に遷移しようとしている場合
				System.out.println("SampleLoginのloginCheck（POST）、session:" + target);
				String redirectsaki = target.substring("/WonFesSys".length());
				return "redirect:" + redirectsaki;
			}else {
				return "top";
			}
		}else {
			model.addAttribute("message","userid, passwordが不正です。再入力してください");
			return "loginerror";
		}
		
	}
	
	@RequestMapping(value = "/accnt/accnt_02", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		session.invalidate();
		return "logout";
		
	}
	
	// TODO USRテーブルのpasswordカラムを見直す
	//	・NOT NULL属性を追加
	private boolean isAuth(String userid, String password) {
		Usr u = usrmapper.selectByPrimaryKey(userid);
		if (u == null) {
			return false;
		}
		String dbpwd = CharMatcher.WHITESPACE.trimTrailingFrom(u.getPasswd());
		String rqpwd = DigestUtils.md5DigestAsHex(password.getBytes());
		if (!Objects.equal(dbpwd, rqpwd)) {
			return false;
		}
		
		return true;
	}
	
	
	
}

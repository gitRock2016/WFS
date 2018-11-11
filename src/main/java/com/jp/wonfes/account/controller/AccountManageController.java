package com.jp.wonfes.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.jp.wonfes.auth.LoginForm;
import com.jp.wonfes.cmmn.dao.mapper.DealersMapper;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.common.ImgIconUrl;
import com.jp.wonfes.common.WfsApplicationConf;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.common.WfsMessage;
import com.jp.wonfes.common.WfsSysytemException;
import com.jp.wonfes.dealer.controller.form.DealerEditForm;
import com.jp.wonfes.dealer.controller.form.DealerRegistForm;
import com.jp.wonfes.dealer.logic.DealerRegistLogic;
import com.jp.wonfes.dealer.logic.dto.DeleteDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.EditDealerInfoDto;
import com.jp.wonfes.dealer.logic.dto.RegistDealerInfoDto;

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
		String password=form.getUserpassword();

		if(this.isAuth(userid, password)) {
			// 認証OKの場合
			session.setAttribute("login", "OK");

			Usr u = usrmapper.selectByPrimaryKey(userid);
			session.setAttribute("s_loginId", u.getUsrId());
			session.setAttribute("s_loginName", u.getUserName());
			
			String target = (String) session.getAttribute("target");
			System.out.println("SampleLoginのloginCheck（POST）、session:" + target);
			String redirectsaki = target.substring("/WonFesSys".length());
			return "redirect:" + redirectsaki;
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

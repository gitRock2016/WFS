package com.jp.wonfes.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.account.controller.form.LoginForm;
import com.jp.wonfes.account.logic.AccountManageLogic;
import com.jp.wonfes.account.logic.dto.CheckAccountDto;
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;
import com.jp.wonfes.common.WfsLogicException;
import com.jp.wonfes.domain.auth.WfsSss;

@Controller
public class AccountManageController {
	
	@Autowired
	private UsrMapper usrmapper;
	
	@Autowired
	private AccountManageLogic accountManageLogic;

	@RequestMapping(value = "/accnt/accnt_01/show", method = RequestMethod.GET)
	public String init(Model model) {
		return "login";
	}

	@RequestMapping(value = "/accnt/accnt_01/login", method = RequestMethod.POST)
	public String login(HttpSession session, @ModelAttribute LoginForm form, Model model) {

		String userid = form.getUserid();
		String password = form.getPassword();

		try {
			CheckAccountDto checkDto = new CheckAccountDto();
			checkDto.setUserid(userid);
			checkDto.setPassword(password);
			accountManageLogic.checkAccountInfo(checkDto);
			
			// 認証OKの場合
			session.setAttribute(WfsSss.ISLOGIN.getCode(), WfsSss.OK);

			Usr u = usrmapper.selectByPrimaryKey(userid);
			session.setAttribute(WfsSss.ID.getCode(), u.getUsrId());
			session.setAttribute(WfsSss.NAME.getCode(), u.getUserName());

			String target = (String) session.getAttribute(WfsSss.TARGET.getCode());
			if (target != null) {
				// ログイン画面以外に遷移しようとしていた場合、元々の遷移先にリダイレクトする
				String redirectsaki = target.substring("/WonFesSys".length());
				return "redirect:" + redirectsaki;
			} else {
				return "accountinfo";
			}
		} catch (WfsLogicException e) {
			model.addAttribute("danger_message", e.getMessage());
			return "login";
		}

	}
	
	@RequestMapping(value = "/accnt/accnt_02", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		session.invalidate();
		return "logout";
		
	}
}

package com.jp.wonfes.auth;

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
import com.jp.wonfes.cmmn.dao.mapper.UsrMapper;
import com.jp.wonfes.cmmn.dao.qo.Usr;

/**
 * TODO 認証処理の作成だけしているが、権限制御も実装するようにする
 * TODO せっっしょんごとのユーザー情報を管理するクラスを作成しそこからユーザー名、パスワードの取得、認証チェックなどを行いたい
 * このクラスはシングルトンなのでできないかつ、検索処理が２回しているので非効率なため
 * @author rock
 *
 */
@Controller
public class AuthenticateController {
	
	@Autowired
	private UsrMapper usrmapper;
	
	@RequestMapping(value = "/g00/login", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("get,/g00/login");
		return "login";
	}

	@RequestMapping(value = "/g00/login", method = RequestMethod.POST)
	public String auth(HttpSession session, @ModelAttribute LoginForm form, Model model) {
		System.out.println("post,/g00/login");

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
	
	@RequestMapping(value = "/g00/logout", method = RequestMethod.GET)
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

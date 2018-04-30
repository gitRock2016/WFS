package com.jp.wonfes.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jp.wonfes.service.dao.WfsDataException;
import com.jp.wonfes.service.dao.product.DealerInfoQo;
import com.jp.wonfes.service.dao.product.DealerSampleDao;

/**
 * TODO 認証処理の作成だけしているが、権限制御も実装するようにする
 * @author rock
 *
 */
@Controller
public class AuthenticateController {
	
	@RequestMapping(value = "/g00/login", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("get,/g00/login");
		return "login";
	}

	@RequestMapping(value = "/g00/login", method = RequestMethod.POST)
	public String auth(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		System.out.println("post,/g00/login");

		String username=null;
		String password=null;

		// TODO 認証用Formクラスを作成しそこから取得するようにする
		username=(String) request.getParameter("user");
		password=(String) request.getParameter("password");
		
		// TODO 権限テーブルにアクセスできるようにする
		if(this.isAuth(username, password)) {
			// 認証OKの場合
			session.setAttribute("login", "OK");
			String target = (String) session.getAttribute("target");
			System.out.println("SampleLoginのloginCheck（POST）、session:" + target);
			String redirectsaki = target.substring("/WonFesSys".length());
			return "redirect:" + redirectsaki;
		}else {
			return "loginerror";
		}
		
	}
	
	@RequestMapping(value = "/g00/logout", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		session.invalidate();
		try {
			// TODO WEB-INF直下のindex.jspへの指定が不明だったので、サーブレットを利用している
			//　よくよく考えるとmvc-configでview配下を指定しているのでresponseを利用したこの遷移はルール破り。
			//　最終的にviewフォルダ配下にtop画面など作成すること
			response.sendRedirect("/WonFesSys/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// TODO DBアクセスした認証機能に変更する、
	// TODO md5暗号化処理に変更
	private boolean isAuth(String username, String password) {
		boolean isauth=false;
		
		if(username.equals("iwatakhr") && password.equals("password")) {
			isauth=true;
		}
		return isauth;
	}
	
	
	
}

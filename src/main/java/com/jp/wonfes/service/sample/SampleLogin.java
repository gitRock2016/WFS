package com.jp.wonfes.service.sample;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleLogin {

	@RequestMapping(value = "/g00/login", method = RequestMethod.GET)
	public String init(Model model) {
		System.out.println("get,/g00/login");
		return "samplelogin";
	}

	@RequestMapping(value = "/g00/login", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		System.out.println("post,/g00/login");
		String userid=null;
		userid=(String) request.getParameter("user");
		if(userid.equals("iwatakhr")) {
			// 認証OKの場合
			session.setAttribute("login", "OK");
			String target = (String) session.getAttribute("target");
			System.out.println("SampleLoginのloginCheck（POST）、session:"+target);
			
			// TODO ↓SprimgMVCを利用しているので、コンテキストが2重になっている
			//targetからコンテキスト名を除きたい
//			return "redirect:"+target;
			
			int last =target.length()+1;
			String redirectsaki=target.substring("/WonFesSys".length());
			return "redirect:"+redirectsaki;
			
			
		}else {
			return "samplelogin";
		}
		
		
	}
	
	@RequestMapping(value = "/g00/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		session.invalidate();
		return "index";
	}
	

}

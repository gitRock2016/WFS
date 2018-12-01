package com.jp.wonfes.domain.auth;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TODO filterの適用対象URLは除外設定ができない、url自体の構成を見直す
 * ログイン機能　　/login/g01/login
 * ワンフェス機能　/wonfes/g01/search
 * ワンフェス機能　/wonfes/g01/regist
 * 
 * 
 * @author rock
 *
 */
public class AuthFilter implements Filter {

	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		String url = ((HttpServletRequest) request).getRequestURI();
		String params = ((HttpServletRequest) request).getQueryString();
		String target = url;
		if (params != null) {
			target = url + "?" + params;
		}
		if (session == null) {
			session = ((HttpServletRequest) request).getSession(true);
			session.setAttribute(WfsSss.TARGET.getCode(), target);
			((HttpServletResponse) response).sendRedirect("/WonFesSys/accnt/accnt_01/show");
		} else {
			Object loginCheck = session.getAttribute(WfsSss.ISLOGIN.getCode());
			if (loginCheck == null) {
				session.setAttribute(WfsSss.TARGET.getCode(), target);
				((HttpServletResponse) response).sendRedirect("/WonFesSys/accnt/accnt_01/show");
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}

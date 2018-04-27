package com.jp.wonfes.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userdetailservice;
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// form認証
		http.formLogin() // フォーム認証を有効にする
				.loginPage("/samplelogin") // ログインページの指定
				/** 認証成功・失敗時の遷移先はデフォルト指定を利用するため、コメントアウト*/
	//			.defaultSuccessUrl("/menu") // 認証成功時に遷移するパスを明示的に指定できる
	//			.failureUrl("/loginFailure") // 認証失敗時に遷移するパスを明示的に指定できる
				.permitAll(); //　全ユーザへログインページへのアクセス権を付与、ログインフォームへのアクセス権はないとリダイレクトエラーになる
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	@Autowired
	void configureAuthenticationManage(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailservice) // DaoAuthenticationProviderを有効化
				.passwordEncoder(passwordEncoder()); // BCryptアルゴリズムを使用してハッシュ化する
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

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
//　TODO　webxmlの設定がうまく行かないので、xmlで設定する。暫定コメントアウト
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
public class WebSecurityConfig {

		//	@Autowired
//	UserDetailsService userdetailservice;
//	
//	@Override
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers("/resources/**");
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		// form認証
//		http.formLogin() // フォーム認証を有効にする
//			/**
//			 * デフォルトのログインURL「/login」
//			 * 「/login」、GET通信⇒ログインフォームのｊｓｐを表示するコントローラの呼び出し
//			 * 「/login」、POST通信⇒ログイン処理(認証処理）機能の呼び出し
//			 * */
//				// 「/login」、GET通信のURLを、デフォルトから指定したい場合に設定する
////				.loginPage("/samplelogin") 
//				/** 認証成功・失敗時の遷移先urlはデフォルト指定を利用するため、コメントアウト*/
////				.defaultSuccessUrl("/menu") // 認証成功時の遷移先urlを明示的に指定できる
//			/**
//			 * デフォルトの認証失敗時の遷移先url「/login?error」
//			 * */
////				.failureUrl("/loginFailure") // 認証失敗時の遷移先urlを明示的に指定できる
//				.permitAll(); // 全ユーザへログインページへのアクセス権を付与、ログインフォームへのアクセス権はないとリダイレクトエラーになる
//
//		http.authorizeRequests().anyRequest().authenticated();
//		
//		http.logout() // ログアウト処理を有効にする
//				/**
//				 * デフォルトのログアウトURL「/logout」
//				 */
////				.logoutUrl("/auth/logout") // ログアウトURLの変更
//				/**
//				 *  デフォルトのログアウト処理成功時に遷移先url「[ログインURL]/logout」
//				 * */
////				.logoutSuccessUrl("/logoutSuccess") // ログアウト処理成功時に遷移先urlの変更
//				.permitAll(); // 全ユーザへログアウトへのアクセス権を付与
//		
//		
//		
//	}
//	
//	@Autowired
//	void configureAuthenticationManage(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userdetailservice) // DaoAuthenticationProviderを有効化
//				.passwordEncoder(passwordEncoder()); // BCryptアルゴリズムを使用してハッシュ化する
//	}
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
}

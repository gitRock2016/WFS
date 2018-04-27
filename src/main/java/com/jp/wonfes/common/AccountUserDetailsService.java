package com.jp.wonfes.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService implements UserDetailsService {

	// TODO Accountクラスはmapperインターフェースをインジェクションして取得するようにする
	
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Account ac = this.getAccountMock();
		
		return null;
	}
	
	private Collection<GrantedAuthority> getAuthorities(Account a){
		if(a.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		}else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
	
	private Account getAccountMock() {
		Account a = new Account();
		a.setUserName("iwatakhr");
		a.setPassword("password");
		return a;
		
	}

}

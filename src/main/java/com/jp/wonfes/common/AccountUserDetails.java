package com.jp.wonfes.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails {
	
	private final Account ac;
	private final Collection<GrantedAuthority>  authorities;
	
	
	public AccountUserDetails(Account ac, Collection<GrantedAuthority> authorities) {
		super();
		this.ac = ac;
		this.authorities = authorities;
	}

	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getPassword() {
		return ac.getPassword();
	}

	public String getUsername() {
		return ac.getUserName();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		return ac.isEnabled();
	}

	public Account getAc() {
		return ac;
	}
	

}

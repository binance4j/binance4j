package com.binance4j.web.dto;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/** User details with username and password only. */
public class UsernamePasswordUserDetails extends Binance4jUserDetails {
	/**
	 * @param username username.
	 * @param password password.
	 */
	public UsernamePasswordUserDetails(String username, String password) {
		super(username, password, username, password);
		authorities = Set.of(new SimpleGrantedAuthority("BASIC"));
	}

	public UsernamePasswordUserDetails(Authentication authentication) {
		super(authentication);
	}
}
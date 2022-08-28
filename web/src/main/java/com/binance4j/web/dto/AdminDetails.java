package com.binance4j.web.dto;

import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdminDetails extends Binance4jUserDetails {
	/**
	 * Creates instance.
	 * 
	 * @param username Username.
	 * @param password Password.
	 * @param key      Key.
	 * @param secret   Secret.
	 */
	public AdminDetails(String username, String password, String key, String secret) {
		super(username, password, key, secret);
		authorities = Set.of(new SimpleGrantedAuthority("ANONYMOUS"));
	}
}
package com.binance4j.web.dto;

import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/** Anonymous user using Binance api and secret keys */
public class AnonymousUserDetails extends Binance4jUserDetails {
	/**
	 * Creates instance.
	 * 
	 * @param key    key.
	 * @param secret secret.
	 */
	public AnonymousUserDetails(String key, String secret) {
		super(key, secret, key, secret);
		authorities = Set.of(new SimpleGrantedAuthority("ANONYMOUS"));
	}
}
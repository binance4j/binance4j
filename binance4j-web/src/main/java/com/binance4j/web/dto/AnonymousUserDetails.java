package com.binance4j.web.dto;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** Anonymous user using Binance api and secret keys */
public class AnonymousUserDetails implements UserDetails {
	/** Key. */
	String key;
	/** Secret. */
	String secret;
	/** Authorities. */
	Set<SimpleGrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("ANONYMOUS"));

	/**
	 * @param key    key.
	 * @param secret secret.
	 */
	public AnonymousUserDetails(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return key;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return secret;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "AnonymousUserDetails [authorities=" + authorities + ", key=" + key + ", secret=" + secret + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
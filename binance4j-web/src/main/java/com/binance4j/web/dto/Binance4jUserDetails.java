package com.binance4j.web.dto;

import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class Binance4jUserDetails implements UserDetails {
	/** Username. */
	String username;
	/** Password. */
	String password;
	/** Key. */
	String key;
	/** Secret. */
	String secret;
	/** Is account non expired? */
	boolean accountNonExpired;
	/** Is account non locked? */
	boolean accountNonLocked;
	/** Are credentials non expired? */
	boolean credentialsNonExpired;
	/** Is user enabled? */
	boolean enabled;
	/** Authorities. */
	Set<SimpleGrantedAuthority> authorities;

	/**
	 * Creates instance.
	 * 
	 * @param username Username.
	 * @param password Password.
	 * @param key      Key.
	 * @param secret   Secret.
	 */
	public Binance4jUserDetails(String username, String password, String key, String secret) {
		this.username = username;
		this.password = password;
		this.key = key;
		this.secret = secret;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @return the authorities
	 */
	public Set<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}

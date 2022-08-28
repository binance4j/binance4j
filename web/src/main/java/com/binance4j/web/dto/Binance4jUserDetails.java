package com.binance4j.web.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class Binance4jUserDetails:UserDetails
{
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
	Set<? extends GrantedAuthority> authorities;

	/**
	 * Creates instance.
	 * 
	 * @property username Username.
	 * @property password Password.
	 * @property key      Key.
	 * @property secret   Secret.
	 */
	protected Binance4jUserDetails(String username, String password, String key, String secret) {
		this.username = username;
		this.password = password;
		this.key = key;
		this.secret = secret;
	}

	/**
	 * Creates instance from a spring security {@link Authentication}.
	 * 
	 * @property authentication Security authentication to copy the data from.
	 */
	protected Binance4jUserDetails(Authentication authentication) {
		this.username = (String) authentication.getPrincipal();
		this.password = (String) authentication.getCredentials();
		this.authorities = new HashSet<>(authentication.getAuthorities().stream().toList());
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
	public Set<? extends GrantedAuthority> getAuthorities() {
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

package com.binance4j.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.dto.AnonymousUserDetails;

public abstract class AuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	Connectors connectors;

	/**
	 * Authenticate user in the security context.
	 * 
	 * @param userDetails User to authenticate.
	 * @param key         API public key.
	 * @param secret      API secret key.
	 */
	public void authenticateUser(UserDetails userDetails, String key, String secret) {
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
				userDetails.getUsername(), userDetails.getPassword(),
				userDetails.getAuthorities()));
		connectors.rest().updateKeys(key, secret);
	}

	/**
	 * Authenticate user in the security context.
	 * 
	 * @param userDetails User to authenticate.
	 * @param key         API public key.
	 * @param secret      API secret key.
	 */
	public void authenticateUser(String key, String secret) {
		SecurityContextHolder.getContext()
				.setAuthentication(generateToken(new AnonymousUserDetails(key, secret)));
		connectors.rest().updateKeys(key, secret);
	}

	/**
	 * @return Is user already authenticated?
	 */
	public boolean isAlreadyAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	/**
	 * Generates an authentication token from user details.
	 * 
	 * @param userDetails input user details
	 * @return An authentication token
	 */
	public static AbstractAuthenticationToken generateToken(UserDetails userDetails) {
		return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
				userDetails.getAuthorities());
	}
}

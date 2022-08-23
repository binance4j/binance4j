package com.binance4j.web.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.dto.Binance4jUserDetails;

/** User authentication management service */
@Service
public class AuthenticationService {
	Connectors connectors;

	/**
	 * @param connectors
	 */
	public AuthenticationService(Connectors connectors) {
		this.connectors = connectors;
	}

	/**
	 * Authenticate user in the security context.
	 * 
	 * @param userDetails User to authenticate.
	 */
	public void authenticateUser(Binance4jUserDetails userDetails) {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
						userDetails.getAuthorities()));
		connectors.rest().updateKeys(userDetails.getKey(), userDetails.getSecret());
	}

	/**
	 * @return Is user already authenticated?
	 */
	public boolean isAlreadyAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}
}

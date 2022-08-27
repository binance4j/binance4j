package com.binance4j.web.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.dto.Binance4jUserDetails;
import com.binance4j.web.dto.UsernamePasswordUserDetails;

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
	public boolean authenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	/**
	 * 
	 * @return Authenticated user.
	 */
	public UsernamePasswordUserDetails getAuthenticatedUser() {
		return new UsernamePasswordUserDetails(SecurityContextHolder.getContext().getAuthentication());
	}

}

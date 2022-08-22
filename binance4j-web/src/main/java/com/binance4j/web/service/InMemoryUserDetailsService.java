package com.binance4j.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binance4j.core.exception.ApiException;
import com.binance4j.web.entity.Credentials;
import com.binance4j.web.entity.InMemoryUserDetails;

/** Service to authenticate the in memory user in the security context. */
@Service
public class InMemoryUserDetailsService implements UserDetailsService {
	@Autowired
	InMemoryUserDetails inMemoryUserDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return inMemoryUserDetails.getUsername().equals(username) ? inMemoryUserDetails : null;
	}

	/**
	 * Compares in memory user credentials with given credentials.
	 * 
	 * @param credentials credentials to compare with
	 * @return credentials validity.
	 */
	public boolean validateCredentials(Credentials credentials) {
		return credentials.getPassword().equals(inMemoryUserDetails.getPassword())
				&& inMemoryUserDetails.getUsername().equals(credentials.getUsername());
	}

	/**
	 * Authenticates the in memory user in the security context.
	 */
	public void authenticateUser() throws ApiException {
		AbstractAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				inMemoryUserDetails.getUsername(), inMemoryUserDetails.getPassword(),
				inMemoryUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	/**
	 * @return the inMemoryUserDetails
	 */
	public InMemoryUserDetails getInMemoryUserDetails() {
		return inMemoryUserDetails;
	}
}

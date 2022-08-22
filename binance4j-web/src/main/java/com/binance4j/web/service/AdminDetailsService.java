package com.binance4j.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binance4j.web.dto.AdminDetails;
import com.binance4j.web.dto.Credentials;

/** Service to authenticate admin. */
@Service
public class AdminDetailsService implements UserDetailsService {
	@Autowired
	AdminDetails adminDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return adminDetails.getUsername().equals(username) ? adminDetails : null;
	}

	/**
	 * Compares in memory user credentials with given credentials.
	 * 
	 * @param credentials credentials to compare with
	 * @return credentials validity.
	 */
	public boolean validateCredentials(Credentials credentials) {
		return credentials.getPassword().equals(adminDetails.getPassword())
				&& adminDetails.getUsername().equals(credentials.getUsername());
	}

}

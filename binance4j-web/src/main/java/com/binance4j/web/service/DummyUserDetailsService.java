package com.binance4j.web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binance4j.web.dto.Binance4jUserDetails;

/**
 * DUmmy user details service.
 */
@Service
public class DummyUserDetailsService implements Binance4jUserDetailsService {

	@Override
	public Binance4jUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public boolean validatePassword(UserDetails userDetails, String password) {
		return false;
	}
}

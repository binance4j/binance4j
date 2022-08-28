package com.binance4j.web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.binance4j.web.dto.Binance4jUserDetails;
import com.binance4j.web.dto.Credentials;

@Service
public interface Binance4jUserDetailsService extends UserDetailsService {
	/**
	 * Loads user by username then validates password.
	 * 
	 * @param username Username.
	 * @param password Password.
	 * @return the user details if username and password match, else null.
	 */
	public default UserDetails loadUser(Credentials credentials) {
		UserDetails userDetails = loadUserByUsername(credentials.getUsername());
		if (userDetails == null) {
			return null;
		}
		if (!validatePassword(userDetails, credentials.getPassword())) {
			return null;
		}
		return userDetails;
	}

	@Override
	public abstract Binance4jUserDetails loadUserByUsername(String username);

	/**
	 * Compares user password and given password.
	 * 
	 * @param userDetails
	 * @param password
	 * @return the equality between the user details password and the given
	 *         password.
	 */
	public abstract boolean validatePassword(UserDetails userDetails, String password);
}

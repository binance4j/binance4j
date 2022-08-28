package com.binance4j.web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binance4j.web.dto.AdminDetails;
import com.binance4j.web.dto.Binance4jUserDetails;

/**
 * Service to authenticate the admin user registered in application.properties.
 */
@Service
public class AdminDetailsService:Binance4jUserDetailsService
{
	private final AdminDetails adminDetails;

	/**
	 * Creates instance.
	 * 
	 * @param adminDetails Admin details.
	 */
	public AdminDetailsService(AdminDetails adminDetails) {
		this.adminDetails = adminDetails;
	}

	@Override
	public Binance4jUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return adminDetails.getUsername().equals(username) ? adminDetails : null;
	}

	@Override
	public boolean validatePassword(UserDetails userDetails, String password) {
		return userDetails.getPassword().equals(password);
	}

	/**
	 * @return the adminDetails
	 */
	public AdminDetails getAdminDetails() {
		return adminDetails;
	}
}
